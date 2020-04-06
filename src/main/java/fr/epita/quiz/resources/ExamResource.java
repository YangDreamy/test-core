package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.business.ExamDataService;


@Path("/exam")
public class ExamResource {
	
	@Inject 
	ExamDataService examDS;
	

	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	//@RequestBody general when we use post and put the parameter into the requestbody
	public Response addAnswerToQuestion(@RequestBody Answer answer) {
		//dummy code, to be replaced
		answer.setId(1l);
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		return Response.serverError().build();
	
	}
	
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getAnswer(@PathParam("id") long answerId) {
		//beginning dummy implementation
		Answer answer = new Answer();
		answer.setContent("This is a sampleAnswer with id " + answerId);
		answer.setId(answerId);
		return Response.ok(answer).build();
	}
	
	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response getAnswers() {
		
		//beginning dummmy implementation 开始虚拟的实现  get is read
		Answer answer = new Answer();
		answer.setContent("This is a sampleAnswer");
		return Response.ok(Arrays.asList(answer)).build();
	}
	
	
	//PUT
	@PUT
	@Path("/answer/{id}/{content}")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response updateAnswers(@PathParam("content") String content,@PathParam("id") long answerId) {
		Answer answer = new Answer();
		answer.setId(answerId);
		answer.setContent(content);
		return Response.ok(answer).build();
		
	}
	
	//DELETE
	@DELETE
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response deleteAnswers(@PathParam("id") long answerId) {
		Answer answer = new Answer();
		return Response.ok(Arrays.asList(answer)).build();
		
	}
	
	
}
