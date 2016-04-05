package com.five9group.springWeb.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:springContextForTest.xml" })
public class ShowTutorialListTest {

	 @Autowired
	 private WebApplicationContext wac;
	 
	 private MockMvc mockMvc;
	 
	 @Before
	 public void setup() {
	  this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	 }
	
	
	
	@Test
	public void showTutorialList()throws Exception{
		mockMvc.perform(get("/"))
		          .andExpect(status().isOk())
		          .andExpect(view().name("viewListOfTutorials"))
		          .andExpect(forwardedUrl("/WEB-INF/views/viewListOfTutorials.jsp"));
	}
}
