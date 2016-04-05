package com.five9group.springWeb.service;


import com.five9group.springWeb.domain.*;

	 
	 
	public interface TutorialManager {
		public void addTutorial(Tutorial tutorial)throws Exception;
		public void deleteTutorial(Tutorial tutorial)throws Exception ;
		public void updateTutorial(Tutorial tutorial)throws Exception ;
	}
