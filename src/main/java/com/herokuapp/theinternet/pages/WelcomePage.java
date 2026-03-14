package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {
	
	private By formAuthenticationLocator = By.linkText("Form Authentication"); 
	private By checkboxesLocator = By.linkText("Checkboxes"); 
	private By dropdownLocator = By.linkText("Dropdown"); 
	private By javaScriptAlertsLocator = By.linkText("JavaScript Alerts"); 
	private By multipleWindowsLocator = By.linkText("Multiple Windows");
	private By editorLocator = By.linkText("WYSIWYG Editor"); 
	private By nestedFramesLocator = By.linkText("Nested Frames"); 
	private By keyPressesLocator = By.linkText("Key Presses");

	String pageUrl = "http://the-internet.herokuapp.com/";

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public void openPage() {		
		log.info("Open page " + pageUrl); 
		super.openPage(pageUrl);
		log.info("Page opened...");
	}
	
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page"); 
		click(formAuthenticationLocator); 		
		return new LoginPage(driver, log); 		
	}
	
	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page"); 
		click(checkboxesLocator); 
		return new CheckboxesPage(driver, log); 
	}	
	
	public DropdownPage clickDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page"); 
		click(dropdownLocator); 
		return new DropdownPage(driver, log); 		
	}	
	
	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts link on Welcome Page");
		click(javaScriptAlertsLocator); 
		return new JavaScriptAlertsPage(driver, log);
	}
	
	public WindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		click(multipleWindowsLocator); 
		return new WindowsPage(driver, log);
	}
	
	public void scrollToEditorLink() {
		log.info("Scrolling to WYSIWYGEditor Editor Link");
		scrollToElementView(editorLocator); 		
	}
	
	public EditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking Editor link on Welcome Page");
		click(editorLocator); 
		return new EditorPage(driver, log); 
	}
	
	public NestedFramesPage clickNestedFrameLink() {
		log.info("Clicking Nested Frames link on Welcome Page");
		click(nestedFramesLocator); 		
		return new NestedFramesPage (driver, log);
	}
	
	public KeyPressesPage clickKeyPressesLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPressesLocator); 
		return new KeyPressesPage(driver, log);
	}
	
}