package com.five9group.springWeb.domain;

public class Tutorial {

	private Integer id;
	private String tutorialTitle;
	private String tutorialAuthor;
	private String tutorialDescription;
	
	public final String getTutorialTitle() {
		return this.tutorialTitle;
	}
	public final void setTutorialTitle(final String tutorialTitle) {
		this.tutorialTitle = tutorialTitle;
	}
	public final String getTutorialAuthor() {
		return this.tutorialAuthor;
	}
	public final void setTutorialAuthor(final String tutorialAuthor) {
		this.tutorialAuthor = tutorialAuthor;
	}

	public final String getTutorialDescription() {
		return this.tutorialDescription;
	}
	public final void setTutorialDescription(final String tutorialDescription) {
		this.tutorialDescription = tutorialDescription;
	}
	public final Integer getId() {
		return this.id;
	}
	public final void setId(final Integer id) {
		this.id = id;
	}
	
}
