package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting LogIn test");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		takeScreenshot("WelcomePage opened");

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		takeScreenshot("LoginPage opened");

		// Execute login
		SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened");
		
		// Wait for success message
		secureAreaPage.waitForSuccessMsg();
		String actualSuccessMessage = secureAreaPage.getSuccessMsgText();		

		// Verifications

		// Logout button is visible
		Assert.assertTrue(secureAreaPage.isLogoutBtnDisplayed(), "Logout button is not displayed");

		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentURL(), secureAreaPage.getPageUrl());		

		// Successful login message
		String expectedSuccessMessage = "You logged into a secure area!";		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
