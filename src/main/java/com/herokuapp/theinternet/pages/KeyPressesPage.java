package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage extends BasePage{
	
	//private By targetFieldLocator = By.id("target");
	private By targetLocator = By.xpath("//body"); 
	private By resultFieldLocator = By.id("result");
	
	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log); 		
	}
	
	public void typeText(String text) {
		find(targetLocator).sendKeys(text);		
		log.info("Typed in: " + text);
	}
	
	public void pressKey(Keys key) {
		log.info ("Press: " + key.name()); 		
		pressKey(targetLocator, key);
	}	
	
	public String getResultText() {
		String text = find(resultFieldLocator).getText(); 
		log.info ("Result text: " + text); 	
		return text; 		
	}	

}
