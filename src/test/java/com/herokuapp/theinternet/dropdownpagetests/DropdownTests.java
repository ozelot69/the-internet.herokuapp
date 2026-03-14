package com.herokuapp.theinternet.dropdownpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DropdownTests extends TestUtilities {

	@Test
	public void selectDropdownOption() {
		log.info("Starting Select Dropdown option test");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink(); 
		
		//Select dropdown option
		dropdownPage.selectDropdownOption(1);
		
		//Verify selection
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 1"), "Option 1 is not selected. Instead selected - " + selectedOption);
		
		//Assert.assertTrue(dropdownPage.getSelectedOption().contains("1"), "Incorrect option is selected");
		//Assert.assertTrue(dropdownPage.getSelectedOption().equals("Option 1"), "Incorrect option is selected");
		//Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1",  "Incorrect option is selected");
	

	}

}
