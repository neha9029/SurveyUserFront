package com.user.modelRequest;

import java.util.List;

public class WrapperForQuestions {

	List<SurveyQuestions> surveyQuestions;

	public List<SurveyQuestions> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQesitions(List<SurveyQuestions> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

	public WrapperForQuestions(List<SurveyQuestions> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

	@Override
	public String toString() {
		return "WrapperForQuestions [surveyQesitions=" + surveyQuestions + "]";
	}
	
}
