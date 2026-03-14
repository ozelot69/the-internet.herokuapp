package com.herokuapp.theinternetkeypressestests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesTests extends TestUtilities {
	
	@Test	
	public void pressKeyTest() {
		log.info("Starting pressKeyTest");
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Key Presses link
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink(); 
		
		//Type text and press Enter 
		//keyPressesPage.typeText("S");
		
		//Press Enter key 
		keyPressesPage.pressKey(Keys.ENTER);
		
		//Get entered text
		String text = keyPressesPage.getResultText(); 
		
		//Verify entered text
		//Assert.assertTrue(text.equals("You entered: S"), "The text is not correct");
		
		//Verify Press Key pressed
		Assert.assertTrue(text.equals("You entered: ENTER"), "The text is not correct");
	}
	
	@Test	
	public void pressKeyWithActionTest() {
		log.info("Starting pressKeyWithActionTest");
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Key Presses link
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();		
		
		//Press Enter key 
		keyPressesPage.pressKeyWithActions(Keys.CONTROL);
		
		//Get entered text
		String text = keyPressesPage.getResultText();		
		
		//Verify Press Key pressed
		Assert.assertTrue(text.equals("You entered: CONTROL"), "The result is not correct");
	}


}
