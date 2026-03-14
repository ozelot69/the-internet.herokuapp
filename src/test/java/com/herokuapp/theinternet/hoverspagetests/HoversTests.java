package com.herokuapp.theinternet.hoverspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;

public class HoversTests extends TestUtilities{
	
	@Test
	public void hoverProfileTest() {
		log.info("Starting hoverProfile1Test");
		
		//Open Hovers page
		HoversPage hoversPage = new HoversPage(driver, log);
		hoversPage.openPage();
		
		//Open user profile
		hoversPage.openProfile(3);			
		
		//Verify url		
		Assert.assertTrue(hoversPage.getCurrentURL().contains("/users/3"), "URL is not correct");
	}	

}
