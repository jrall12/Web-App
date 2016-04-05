package com.five9group.springWeb.service;

import org.springframework.transaction.annotation.Transactional;

import com.five9group.springWeb.service.*;
import com.five9group.springWeb.domain.Tutorial;


public class TutorialManagerImpl implements TutorialManager {

	private TutorialDAO tutorialDAO;
	 
    public void setCustomerDAO(TutorialDAO tutorialDAO) {
        this.tutorialDAO = tutorialDAO;
    }
	
	
	@Override
	@Transactional
	public void addTutorial(Tutorial tutorial) throws Exception {
		// TODO Auto-generated method stub
		tutorialDAO.addTutorial(tutorial);
	}

	@Override
	@Transactional
	public void deleteTutorial(Tutorial tutorial) throws Exception {
		// TODO Auto-generated method stub
		tutorialDAO.deleteTutorial(tutorial);
	}

	@Override
	@Transactional
	public void updateTutorial(Tutorial tutorial) throws Exception {
		// TODO Auto-generated method stub
		tutorialDAO.updateTutorial(tutorial);
	}



	


	
	
}
