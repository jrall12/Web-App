package com.five9group.springWeb.functional; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class YahooSearchTest {

	//this is an sample test. use this to extend functional tests
	
	private WebDriver driver;
	private String expectedTitle ="List Of Tutorials";

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();

		//Navigate to desired web page
		driver.get("http://localhost:8080/springWeb/");
	}
	
	@Test
	public void shouldBeAbleToSerarch() 
	{
		

	    driver.findElement(By.partialLinkText("delete Tutorial")).click();
		//for delete
		 driver.findElement(By.xpath(".//*[@id='id']")).sendKeys("18");
         driver.findElement(By.xpath(".//*[@type='submit']")).click();
         
 	    driver.findElement(By.partialLinkText("add Tutorial")).click();
       //for Add
         driver.findElement(By.xpath(".//*[@id='tutorialTitle']")).sendKeys("Java Fun");
		 driver.findElement(By.xpath(".//*[@id='tutorialAuthor']")).sendKeys("Everyone");
		 driver.findElement(By.xpath(".//*[@id='tutorialDescription']")).sendKeys("Fun Java Book");
         driver.findElement(By.xpath(".//*[@type='submit']")).click();         

 	    driver.findElement(By.partialLinkText("update Tutorial")).click();
       //for update
		 driver.findElement(By.xpath(".//*[@id='id']")).sendKeys("3");
		 driver.findElement(By.xpath(".//*[@id='tutorialTitle']")).sendKeys("Amazing Java");
		 driver.findElement(By.xpath(".//*[@id='tutorialAuthor']")).sendKeys("Nobody");
		 driver.findElement(By.xpath(".//*[@id='tutorialDescription']")).sendKeys("The Amazing world of Java");
         driver.findElement(By.xpath(".//*[@type='submit']")).click();
         
		// verify title of index page
         String actualTitle = driver.getTitle();
         assertThat(actualTitle, equalTo(expectedTitle));



	}

}
