package com.five9group.springWeb.service.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.service.impl.TutorialDAOImpl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@ContextConfiguration(locations = {"classpath:DataSourceConfiguration.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TutorialDAOImplTest {
	
	@Autowired
	TutorialDAOImpl tutorialDAOImpl;


	@Ignore
	@Rollback(false)
	public void testInsertData() throws Exception{
		Tutorial tutorial = new Tutorial();
		tutorial.setTutorialDescription("Stories about the lost pacific ");
		tutorial.setTutorialTitle("The Lost Island");
		tutorial.setTutorialAuthor("Bibhuti");
		tutorialDAOImpl.addTutorial(tutorial);
		//get the latest inserted id
		Tutorial insertedTutorial = tutorialDAOImpl.getTutorialById(tutorialDAOImpl.getLatestInsertedRow());
		assertNotNull(insertedTutorial.getTutorialAuthor());	
	}
	
	@Ignore
	public void testDeleteData() throws Exception {
		  boolean thrown = false;
		Tutorial tutorial = new Tutorial();
		tutorial.setId(23);
		try {tutorialDAOImpl.getTutorialById(23);
		System.out.println("Row Still there and equals "  + tutorial.getId());
		} catch (EmptyResultDataAccessException e){System.out.println("Not Deleted yet to retrieve deleted ID");}
		//assertEquals(tutorial.getId(),tutorialDAOImpl.getTutorialById(26));
		tutorialDAOImpl.deleteTutorial(tutorial);
	
			try {tutorialDAOImpl.getTutorialById(26);
				
			} catch (EmptyResultDataAccessException e){System.out.println("Unable to retrieve deleted ID");
				thrown = true;}
		
			assertTrue(thrown);
			}
			
			

	@Ignore 
	public void testUpdateData() throws Exception {
		Tutorial tutorial = new Tutorial();
		tutorial.setId(21);
		tutorial.setTutorialDescription("Java Book");
		tutorial.setTutorialTitle("Java");
		tutorial.setTutorialAuthor("Me");
		tutorialDAOImpl.updateTutorial(tutorial);
		Tutorial updatedTutorial = tutorialDAOImpl.getTutorialById(21);
		assertEquals(updatedTutorial.getTutorialAuthor(),"Me");
		
	}
	
	@Test
	public void testgetID() throws Exception{
		tutorialDAOImpl.getTutorialById(5);
		assertNotNull(tutorialDAOImpl.getTutorialById(5));
		
		
	}
	
	
	@Test
	public void testSelectAllFromTable() throws Exception{
		List<Tutorial> listOfTutorialsInDB =  tutorialDAOImpl.getListOfTutorials();
		assertThat(listOfTutorialsInDB.isEmpty(), is(false));
	}
}
