package com.five9group.springWeb.mvc;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.mvc.form.TutorialForm;
import com.five9group.springWeb.service.TutorialDAO;

@Controller
public class ShowTutorialListController {

	static Logger log = Logger.getLogger(ShowTutorialListController.class.getName());

	@Autowired
	TutorialDAO tutorialDAO;

	@RequestMapping(value = "/viewListOfTutorials", method = RequestMethod.GET)
	public ModelAndView showListOfTutorials() {

		try {
			List<Tutorial> listOfAvailableTutorial = tutorialDAO.getListOfTutorials();
			TutorialForm tutorialForm = new TutorialForm();
			tutorialForm.setListofTutorials(listOfAvailableTutorial);
			return new ModelAndView("viewListOfTutorials", "tutorialForm", tutorialForm);
		} catch (Exception e) {
			log.error("oops! something went wrong" + e);
			return new ModelAndView("error", "command", "");
		}

	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showInitialListOfTutorials() {

		try {
			List<Tutorial> listOfAvailableTutorial = tutorialDAO.getListOfTutorials();
			TutorialForm tutorialForm = new TutorialForm();
			tutorialForm.setListofTutorials(listOfAvailableTutorial);
			return new ModelAndView("viewListOfTutorials", "tutorialForm", tutorialForm);
		} catch (Exception e) {
			log.error("oops! something went wrong" + e);
			return new ModelAndView("error", "command", "");
		}

	}

}
