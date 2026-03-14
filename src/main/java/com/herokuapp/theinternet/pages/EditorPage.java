package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePage {

	private By alertButtonLocator = By.xpath("//button[contains(@class, 'tox-notification__dismiss')]");
	//private  By alertButtonLocator = By.cssSelector("button[class*='tox-notification__dismiss']");	
	private By frameLocator = By.id("mce_0_ifr");
	private By textLocator = By.id("tinymce");	

	public EditorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void closeNotification() {		
		waitElementToBeClickable(alertButtonLocator, Duration.ofSeconds(5));		
		click(alertButtonLocator);
	}

	public String getEditorText() {		
		swithToFrame(frameLocator);
		String text = find(textLocator).getText();
		log.info("Editor text: " + text);
		return text;
	}	

}
