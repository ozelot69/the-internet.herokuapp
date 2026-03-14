package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {
	
	private By topFrameLocator = By.xpath("//frame[@name='frame-top']");	
	private By leftFrameLocator = By.xpath("//frame[@name='frame-left']"); 
	private By middleFrameLocator = By.xpath("//frame[@name='frame-middle']"); 
	private By rightFrameLocator = By.xpath("//frame[@name='frame-right']"); 
	private By bottomFrameLocator = By.name("//frame[@name='frame-bottom']"); 	
	
	private By textLocator = By.xpath("//body"); 
	private By middleTextLocator = By.xpath("//div[@id='content']"); 
	

	public NestedFramesPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public String getLeftFrameText() {		
		swithToFrame(topFrameLocator);		
		swithToFrame(leftFrameLocator);
		String text = find(textLocator).getText();
		log.info("Left Frame text: " + text);
		return text;
	}
	
	public String getMiddleFrameText() {		
		swithToFrame(topFrameLocator);		
		swithToFrame(middleFrameLocator);
		String text = find(middleTextLocator).getText();
		log.info("Middle Frame text: " + text);
		return text;
	}	
	
	public String getRightFrameText() {		
		swithToFrame(topFrameLocator);		
		swithToFrame(rightFrameLocator);
		String text = find(textLocator).getText();
		log.info("Middle Frame text: " + text);
		return text;
	}
	
	public String getBottomFrameText() {		
		driver.switchTo().frame("frame-bottom");		
		//swithToFrame(bottomFrameLocator); //method does not work 		
		String text = find(textLocator).getText();
		log.info("Bottom Frame text: " + text);
		return text;
	}

}
