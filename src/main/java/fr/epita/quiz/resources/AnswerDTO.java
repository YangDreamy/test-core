package fr.epita.quiz.resources;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDTO {
	
	//��Ϊ֮ǰ��exam ������ǰ��entity����
	
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
