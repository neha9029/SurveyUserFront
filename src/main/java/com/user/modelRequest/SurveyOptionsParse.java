package com.user.modelRequest;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "choice", "answer" })
public class SurveyOptionsParse {

	@JsonProperty("choice")
	private String choice;
	@JsonProperty("answer")
	private Boolean answer;
	

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("choice")
	public String getQuestion() {
		return choice;
	}

	@JsonProperty("choice")
	public void setQuestion(String choice) {
		this.choice = choice;
	}

	@JsonProperty("answer")
	public Boolean getAnswer() {
		return answer;
	}

	@JsonProperty("answer")
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
