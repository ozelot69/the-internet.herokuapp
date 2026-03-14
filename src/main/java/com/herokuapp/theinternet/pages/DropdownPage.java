package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
	
	private By dropdownLocator = By.id("dropdown");
	
	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public void selectDropdownOption(int i) {
		log.info("Select option " + i); 
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		//dropdown.selectByIndex(i);
		//dropdown.selectByValue("" + i);
		dropdown.selectByVisibleText("Option " + i);
	}
	
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText(); 
		log.info("The following option is selected : " + selectedOption); 
		return selectedOption; 
	}	

}
