package com.herokuapp.theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	// @Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {
		// we will receive separate Map for each row. Each row for one test execution.

		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMssage");
		String description = testData.get("description");

		log.info("Starting Negative test #" + no + " for " + description);

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// Execute negative login
		loginPage.negativeLogIn(username, password);

		// Wait for error message
		loginPage.waitForErrorMsg();
		String actualErrorMessage = loginPage.getErrorMsgText();

		// Verification
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
