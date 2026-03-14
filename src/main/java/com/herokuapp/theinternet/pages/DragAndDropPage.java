package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage{
	
	private By aElementLocator = By.id("column-a"); 
	private By bElementLocator = By.id("column-b"); 
	
	String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop"; 
	
	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log); 
	}
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		super.openPage(pageUrl);
		log.info("Page opened...");				
	}
	
	public void dragAndDropAtoB() {
		log.info("Perform drag and drop A to B");
		performDragAndDrop(aElementLocator, bElementLocator); 		 			
	}
	
	public String getColumnAText() {		
		String columnAText = find(bElementLocator).getText(); 
		log.info("Element " + columnAText + " is found" + " in element B location");		
		return columnAText; 
	}
	
	public String getColumnBText() {		
		String columnBText = find(aElementLocator).getText(); 
		log.info("Element " + columnBText + " is found" + " in element A location");
		return columnBText; 
	}

}
