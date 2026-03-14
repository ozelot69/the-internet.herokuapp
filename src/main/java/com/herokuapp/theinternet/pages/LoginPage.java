package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	private By usernameLocator = By.id("username"); 
	private By passwordLocator = By.id("password"); 
	private By loginBtnLocator = By.xpath("//button/i[contains(text(), 'Login')]"); 	
	private By errorMsgLocator = By.id("flash"); 

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log); 
	}
	
	public SecureAreaPage login(String username, String password) {
		log.info("Executing login with username [" + username + "] and password [" + password + "]"); 		
		type(username, usernameLocator); 
		type(password, passwordLocator); 
		click(loginBtnLocator); 
		return new SecureAreaPage(driver, log); 	
	}
	
	public void negativeLogIn(String username, String password) {
		log.info("Executing negative login with username [" + username + "] and password [" + password + "]"); 		
		type(username, usernameLocator); 
		type(password, passwordLocator); 
		click(loginBtnLocator); 
	}
	
	//Wait for error message to be visible on the page
	public void waitForErrorMsg() {
		waitForVisibilityOf(errorMsgLocator, Duration.ofSeconds(5)); 
	}
	
	public String getErrorMsgText() {
		return find(errorMsgLocator).getText(); 		
	}

}
