package com.herokuapp.theinternet.nestedframespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.NestedFramesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NestedFramesTests extends TestUtilities {
	
	@Test	
	public void leftFrameGetText() {		
		log.info("Starting leftFrameGetText");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Nested Frames link
		NestedFramesPage nestedFramesPage= welcomePage.clickNestedFrameLink();
		
		//Get text in left frame		
		String textLeftFrame = nestedFramesPage.getLeftFrameText();
		
		//Verify text
		Assert.assertTrue(textLeftFrame.equals("LEFT"), "Left frame text is not correct");
	}	
	
	@Test
	public void middleFrameGetText() {		
		log.info("Starting middleFrameGetText");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Nested Frames link
		NestedFramesPage nestedFramesPage= welcomePage.clickNestedFrameLink();
		
		//Get text in middle frame		
		String textMiddleFrame = nestedFramesPage.getMiddleFrameText();
		
		//Verify text
		Assert.assertTrue(textMiddleFrame.equals("MIDDLE"), "Middle frame text is not correct");
	}
		
	@Test
	public void rightFrameGetText() {		
		log.info("Starting rightFrameGetText");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Nested Frames link
		NestedFramesPage nestedFramesPage= welcomePage.clickNestedFrameLink();
		
		//Get text in middle frame		
		String textRightFrame = nestedFramesPage.getRightFrameText();
		
		//Verify text
		Assert.assertTrue(textRightFrame.equals("RIGHT"), "Right frame text is not correct");
	}
	
	@Test
	public void bottomFrameGetText() {		
		log.info("Starting bottomFrameGetText");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Nested Frames link
		NestedFramesPage nestedFramesPage= welcomePage.clickNestedFrameLink();		
		
		//Get text in bottom frame		
		String textBottomFrame = nestedFramesPage.getBottomFrameText(); 
		
		//Verify text
		Assert.assertTrue(textBottomFrame.equals("BOTTOM"), "Bottom frame text is not correct");
	}

}
