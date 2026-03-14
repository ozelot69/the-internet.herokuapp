package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePage {
	
	private By clickHereLocator = By.linkText("Click Here"); 

	public WindowsPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}	
	
	public void openNewWidnow() {		
		log.info("Select Click Here link to open a new window"); 
		click(clickHereLocator); 		
	}
	
	public NewWindowPage switchToNewWindowPage() {
		log.info("Switch to a new window page"); 
		switchToWindow("New Window"); 
		log.info("Switched to new window. Title: " + driver.getTitle());
		return new NewWindowPage(driver, log);
	}
	
}
