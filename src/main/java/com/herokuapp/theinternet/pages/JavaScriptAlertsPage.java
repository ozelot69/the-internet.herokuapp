package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePage {

	// private By jsAlertBtnLocator = By.xpath("//button[text()='Click for JS
	// Alert']");
	private By jsAlertBtnLocator = By.xpath("//button[@onclick='jsAlert()']");
	private By jsConfirmBtnLocator = By.xpath("//button[@onclick='jsConfirm()']");
	private By jsPromptBntLocator = By.xpath("//button[@onclick='jsPrompt()']");
	private By alertResultLocator = By.id("result");

	public JavaScriptAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openJSAlert() {
		log.info("Select JS Alert button to open alert");
		click(jsAlertBtnLocator);
	}

	public void openJSConfirm() {
		log.info("Select JS Confirm button to open alert");
		click(jsConfirmBtnLocator);

	}

	public void openJSPrompt() {
		log.info("Select JS Propmt button to open alert");
		click(jsPromptBntLocator);
	}

	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says: " + alertText);
		return alertText;
	}

	public void acceptJSAlert() {
		log.info("Switch to alert and select OK button");
		Alert alert = switchToAlert();
		alert.accept();
	}
	
	public void dismissJSAlert() {
		log.info("Switch to alert and select Cancel button");
		Alert alert = switchToAlert();
		alert.dismiss();
	}
	
	public void typeIntoPromptAndAccept(String text) {
		log.info("Switch to alert, type text and select OK button");
		Alert alert = switchToAlert();
		alert.sendKeys(text);
		alert.accept();		
	}	

	public String getResultText() {
		waitForVisibilityOf(alertResultLocator, Duration.ofSeconds(5));
		String result = find(alertResultLocator).getText();
		log.info("Result text: " + result);
		return result;
	}

}
