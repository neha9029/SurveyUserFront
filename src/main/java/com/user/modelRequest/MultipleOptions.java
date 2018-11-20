package com.user.modelRequest;

import java.util.ArrayList;
import java.util.List;

public class MultipleOptions {

	private int optionsDi;
	
	public int getOptionsDi() {
		return optionsDi;
	}

	public void setOptionsDi(int optionsDi) {
		this.optionsDi = optionsDi;
	}

	private long questionsDi;
	
	private boolean asnwer;
	
	public boolean isAsnwer() {
		return asnwer;
	}

	public void setAsnwer(boolean asnwer) {
		this.asnwer = asnwer;
	}

	

	public long getQuestionsDi() {
		return questionsDi;
	}

	public void setQuestionsDi(long questionsDi) {
		this.questionsDi = questionsDi;
	}

	private String optionTitle;

	public String getOptionTitle() {
		return optionTitle;
	}

	public void setOptionTitle(String optionTitle) {
		this.optionTitle = optionTitle;

	}

	public MultipleOptions() {

	}

	public MultipleOptions(String optionTitle) {
		this.optionTitle = optionTitle;
	}

	@Override
	public String toString() {
		return "MultipleOptions [asnwer=" + asnwer + ", optionTitle=" + optionTitle
				+ "]";
	}

}
