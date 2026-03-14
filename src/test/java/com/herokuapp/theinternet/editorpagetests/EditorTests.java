package com.herokuapp.theinternet.editorpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class EditorTests extends TestUtilities {
	
	@Test	
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueTest");

		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Scroll to the bottom of the page		
		//welcomePage.scrollToPageBottom();
		
		//Scroll to WYSIWYGEditor Editor Link
		welcomePage.scrollToEditorLink(); 		
		
		//Click on WYSIWYGEditor link
		EditorPage editorPage= welcomePage.clickWYSIWYGEditorLink(); 
		
		//Close Alert
		editorPage.closeNotification();
		
		//Get text in iFame
		String text = editorPage.getEditorText(); 
		
		//Verify 
		Assert.assertTrue(text.equals("Your content goes here."), "Text is not correct");
	}

}
