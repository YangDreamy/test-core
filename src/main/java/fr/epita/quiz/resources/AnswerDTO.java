package fr.epita.quiz.resources;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDTO {
	
	//因为之前的exam 包括以前的entity不好
	
	//private transient Answer answer; is very close with answer entity
	
	private String content;

	public AnswerDTO(){
		
	}
	public AnswerDTO(Answer entity){
		this.content = entity.getContent();
		
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	

	
	
}
