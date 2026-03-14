package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage{	
	
	private String pageUrl = "https://the-internet.herokuapp.com/secure"; 
	
	private By logoutBtnLocator = By.xpath("//a[@class='button secondary radius']"); 
	private By successMsgLocator = By.id("flash"); 	

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Get URL variable from PageObject
	public String getPageUrl() {
		return pageUrl; 
	}
	
	//Verification if logOutButton is visible on the page
	public boolean isLogoutBtnDisplayed() {
		return find(logoutBtnLocator).isDisplayed(); 
		//return isDisplayed(logoutBtnLocator); 
		
	}
	
	//Wait for success message to be visible on the page
	public void waitForSuccessMsg() {
		waitForVisibilityOf(successMsgLocator, Duration.ofSeconds(5));
	}
	
	//Return text from success message
	public String getSuccessMsgText() {
		return find(successMsgLocator).getText(); 
		//return getMsg(successMsgLocator); 		
	}

}
