package com.ultimateqa.radiobuttonspagetests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.ultimateqa.pages.UltimateqaPage;

public class RadioButtonsTests extends TestUtilities {

	@Test
	public void SelectRadioBtn() {
		log.info("Starting Select Radio Button test");

		// Open ultimateqa page
		UltimateqaPage ultimateqaPage = new UltimateqaPage(driver, log); 
		ultimateqaPage.openPage(); 
		
		// Select a radio button 
		ultimateqaPage.clickRadioBtn();	
		
		sleep(1000); 
		
		// Verify that radio button is selected
		Assert.assertTrue(ultimateqaPage.isRadioBtnChecked(), "Radio button is not selected");	

	}

}
