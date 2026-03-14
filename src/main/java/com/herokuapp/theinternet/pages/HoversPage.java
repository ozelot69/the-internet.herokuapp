package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePage{
	
	private By imgLocator = By.xpath("//div[@class='figure']"); 	
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");	
	//private By img1Locator = By.xpath("//div[@class='example']//div[1]//img[1]"); 
	
	String pageUrl = "http://the-internet.herokuapp.com/hovers"; 
	
	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);		
	} 
	
	public void openPage() {
		log.info("Open page " + pageUrl); 
		super.openPage(pageUrl);
		log.info("Page opened...");
	}
	
	public void openProfile(int i) {
		List<WebElement> images = findAll(imgLocator); 
		WebElement specifiedImage = images.get(i-1); 
		log.info("Hover over Profile " + i);
		hoverOver(specifiedImage); 
		log.info("Open link of profile " + i);
		specifiedImage.findElement(viewProfileLinkLocator).click();				
	}
}
