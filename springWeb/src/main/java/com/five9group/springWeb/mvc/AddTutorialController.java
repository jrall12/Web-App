package com.five9group.springWeb.mvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.service.TutorialDAO;

@Controller
@SessionAttributes
public class AddTutorialController {

	static Logger log = Logger.getLogger(AddTutorialController.class.getName());
	
	@Autowired
	TutorialDAO tutorailDAO;
	
	@Autowired
    @Qualifier("addTutorialValidator")
    private Validator validator;
 
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }


	@RequestMapping(value = "/addTutorial", method = RequestMethod.GET)
	public ModelAndView showAddTutorial() {
		return new ModelAndView("addTutorial", "command", new Tutorial());

	}


	@RequestMapping(value = "/addTutorial", method = RequestMethod.POST)
	public String addTutorial(@ModelAttribute("tutorial")  @Validated Tutorial tutorial, BindingResult result) {

		 if(result.hasErrors()){
			 log.info("Returning addTutorial.jsp page");
	            return "addTutorial";

		 }
		try {
		    log.info("Starting to insert tutorial to database");
			tutorailDAO.addTutorial(tutorial);
			
		} catch (Exception e) {
			log.error("oops! something went wrong"+e);
			return "redirect:error";
		}
		System.out.println(tutorial.getTutorialTitle());
		return "redirect:viewListOfTutorials";
	}

}