package com.ultimateqa.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.herokuapp.theinternet.pages.BasePage;

public class UltimateqaPage extends BasePage {
	
	private By radioBtnFemaleLocator = By.xpath("//form/input[@value='female']"); 
	private By listRadioBtnsLocator = By.xpath("//form/input[@type='radio']"); 
	
	String pageUrl = "https://ultimateqa.com/simple-html-elements-for-automation/"; 

	public UltimateqaPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public void openPage() {
		log.info("Open page" + pageUrl); 
		super.openPage(pageUrl);
		log.info("Page opened..."); 
		
	}
	
	public void clickRadioBtn() {
		log.info("Select a radio button"); 
		click(radioBtnFemaleLocator); 		
	}
	
	public boolean isRadioBtnSelected() {
		log.info("Verifying that a radio button is checked");
		waitForVisibilityOf(radioBtnFemaleLocator, Duration.ofSeconds(5)); 
		WebElement radioBtn = find(radioBtnFemaleLocator); 
		if(radioBtn.isSelected()) {
			return true; 
		}
		return false;
	}
	
	public boolean isRadioBtnChecked() {
		return isChecked(radioBtnFemaleLocator); 
	}	
	

}
