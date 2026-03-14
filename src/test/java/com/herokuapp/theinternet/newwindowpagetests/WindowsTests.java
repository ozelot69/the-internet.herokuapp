package com.herokuapp.theinternet.newwindowpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;

public class WindowsTests extends TestUtilities {
	
	@Test
	public void newWindowTest() {
		log.info("Starting newWindowTest");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click multiple window link
		WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink(); 		
		
		//Click Here link to open a new window 
		windowsPage.openNewWidnow();		
		
		//Switch to a new window
		NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();		
		
		//Get new page title 		
		String title = newWindowPage.getCurrentPageTitle();
		String pageSource = newWindowPage.getCurrentPageSource();		
		
		//Verify title of the new window
		Assert.assertTrue(title.equals("New Window"), "Title is not correct");		
		//Assert.assertTrue(pageSource.contains("New Window"), "New page source does not contain expected text");
	}

}
