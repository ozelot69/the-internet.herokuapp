package com.herokuapp.theinternet.alertspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class JavaScriptAlertsTests extends TestUtilities {	
	
	@Test
	public void jsAlertTest() {
		
		SoftAssert softAssert = new SoftAssert(); 
		
		log.info("Starting JS Alert test");	
		
		//Open main page
		WelcomePage welcomePage= new WelcomePage(driver, log); 
		welcomePage.openPage();
		
		//Click javaScriptAlert link
		JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink(); 
		
		//Click JS Alert button 
		javaScriptAlertsPage.openJSAlert();
		
		//Get Alert text
		String alertText = javaScriptAlertsPage.getAlertText();
		
		//Click OK button 
		javaScriptAlertsPage.acceptJSAlert();
		
		//Get Result text 
		String resultMessage = javaScriptAlertsPage.getResultText(); 
		
		//Verifications
		
		//Verify alert text
		softAssert.assertTrue(alertText.equals("I am a JS Alert"), "Message is not correct. \nShould be 'I am a JS Alert', but it is '" + alertText + "'");
		
		//Verify result text
		softAssert.assertTrue(resultMessage.equals("You successfully clicked an alert"), "Message is not correct. Actual message : '" + resultMessage + "'");
	
		softAssert.assertAll();
	}
	
	@Test
	public void jsConirmTestDismiss() {
		
		SoftAssert softAssert = new SoftAssert(); 		
		
		log.info("Starting JS Confirm Dismiss test");	
		
		//Open main page
		WelcomePage welcomePage= new WelcomePage(driver, log); 
		welcomePage.openPage();
		
		//Click javaScriptAlert link
		JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink(); 
		
		//Click JS Confirm button 
		javaScriptAlertsPage.openJSConfirm();
		
		//Get Alert text
		String alertText = javaScriptAlertsPage.getAlertText();
		
		//Click Cancel button 
		javaScriptAlertsPage.dismissJSAlert();
		
		//Get Result text 
		String resultMessage = javaScriptAlertsPage.getResultText(); 
		
		//Verifications
		
		//Verify alert text
		softAssert.assertTrue(alertText.equals("I am a JS Confirm"), "Message is not correct. \nShould be 'I am a JS Confirm', but it is '" + alertText + "'");
		
		//Verify result text
		softAssert.assertTrue(resultMessage.equals("You clicked: Cancel"), "Message is not correct. Actual message : '" + resultMessage + "'");
		
		softAssert.assertAll();
	}
	
	@Test
	public void jsConirmTestAccept() {
		
		SoftAssert softAssert = new SoftAssert(); 
		
		log.info("Starting JS Confirm Accept test");	
		
		//Open main page
		WelcomePage welcomePage= new WelcomePage(driver, log); 
		welcomePage.openPage();
		
		//Click javaScriptAlert link
		JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink(); 
		
		//Click JS Confirm button 
		javaScriptAlertsPage.openJSConfirm();
		
		//Get Alert text
		String alertText = javaScriptAlertsPage.getAlertText();
		
		//Click Cancel button 
		javaScriptAlertsPage.acceptJSAlert();
		
		//Get Result text 
		String resultMessage = javaScriptAlertsPage.getResultText(); 
		
		//Verifications
		
		//Verify alert text
		softAssert.assertTrue(alertText.equals("I am a JS Confirm"), "Message is not correct. \nShould be 'I am a JS Confirm', but it is '" + alertText + "'");
		
		//Verify result text
		softAssert.assertTrue(resultMessage.equals("You clicked: Ok"), "Message is not correct. Actual message : '" + resultMessage + "'");	
		
		softAssert.assertAll();
	}
	
	
	@Test
	public void jsPromptTest() {
		
		SoftAssert softAssert = new SoftAssert(); 
		
		log.info("Starting JS Prompt test");	
		
		//Open main page
		WelcomePage welcomePage= new WelcomePage(driver, log); 
		welcomePage.openPage();
		
		//Click javaScriptAlert link
		JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink(); 
		
		//Click JS Prompt button 
		javaScriptAlertsPage.openJSPrompt();
		
		//Get Alert text
		String alertText = javaScriptAlertsPage.getAlertText() + "[FAIL]";
		
		//Type into prompt and click OK button 	
		String text = "Hello Alert, it's Svetlana here"; 
		javaScriptAlertsPage.typeIntoPromptAndAccept(text);
				
		//Get Result text 
		String resultMessage = javaScriptAlertsPage.getResultText() + "[FAIL]"; 
	
		//Verifications
		
		//Verify alert text
		softAssert.assertTrue(alertText.equals("I am a JS prompt"), "Alert Message is not correct. \nShould be 'I am a JS prompt', but it is '" + alertText + "'");
		
		//Verify result text
		softAssert.assertTrue(resultMessage.equals("You entered: " + text),
				"Result is not expected. \nShould be " + "You entered: " + text + ", but it is '" + resultMessage + "'");
		
		softAssert.assertAll();
	}


}
