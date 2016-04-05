package com.five9group.springWeb.mvc.form;

import java.util.List;

import com.five9group.springWeb.domain.Tutorial;

public class TutorialForm {

	private List<Tutorial> listofTutorials;

	public List<Tutorial> getListofTutorials() {
		return this.listofTutorials;
	}

	public void setListofTutorials(final List<Tutorial> listofTutorials) {
		this.listofTutorials = listofTutorials;
	}
	
}
