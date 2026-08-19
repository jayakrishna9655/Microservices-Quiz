package com.jai.quiz_service.model;

public class QuizDto {

	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String categoryName;
	private Integer numQuestions;
	private String title;
}
