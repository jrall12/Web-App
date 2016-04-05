package com.five9group.springWeb.service;

import java.util.List;

import com.five9group.springWeb.domain.Tutorial;

public interface TutorialDAO {
	public void addTutorial(Tutorial tutorial)throws Exception;
	public void deleteTutorial(Tutorial tutorial)throws Exception ;
	public void updateTutorial(Tutorial tutorial)throws Exception ;
	public List<Tutorial> getListOfTutorials()throws Exception;
	public Tutorial getTutorialById(Integer Id)throws Exception;
	public int getLatestInsertedRow()throws Exception;
	

}
