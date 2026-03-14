package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities{
	
	@Test
	public void dragAndDropAtoB() {
		log.info("Starting dragAndDropTest");
		
		//Open Drag and Drop page
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
		dragAndDropPage.openPage();
		
		//Drag and Drop A to B
		dragAndDropPage.dragAndDropAtoB();
		
		//Verify that A is moved to B
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("A"), "Element A is not moved to element B location");
		
		//Verify that B is moved to A
		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("B"), "Element B is not moved to element A location");
		
	}

}
