package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities {

	@Test
	public void selectTwoCheckboxesTest() {
		log.info("Starting Select Two Checkboxes test");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Checkboxes link 
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
		
		//Select all checkboxes
		//log.info("Selecting checkbox1");
		//checkboxesPage.clickCheckbox1();
		
		//log.info("Selecting checkbox2");
		//checkboxesPage.clickCheckbox2();
		
		checkboxesPage.clickAllCheckboxes();
		
		//Verify all checkboxes are checked 
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
		//Assert.assertTrue(checkboxesPage.isCheckbox1Checked(), "Checkbox 2 is not selected");
	}

}
