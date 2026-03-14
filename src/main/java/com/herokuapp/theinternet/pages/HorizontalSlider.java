package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSlider extends BasePage {

	private By sliderLocator = By.xpath("//input[@type='range']");
	// private By sliderLocator = By.tagName("input");
	private By rangeLocator = By.id("range");

	String pageUrl = "http://the-internet.herokuapp.com/horizontal_slider";

	public HorizontalSlider(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		log.info("Open page " + pageUrl);
		super.openPage(pageUrl);
		log.info("Page opened...");
	}

	public void moveSliderTo(String value) {
		
		// Move slider with Actions class method
		// Find the xOffset using given value
//		int width = find(sliderLocator).getSize().getWidth(); 
//		System.out.println("Width of the slider " + width);
//		double persent = Double.parseDouble(value)/5; 
//		int xOffSet = (int)(width * persent); 
//		setSliderTo(sliderLocator, xOffSet); 
//		log.info("Slider is moved to " + xOffSet);

		// Move slider with sendKeys(Keys.ARROW_RIGHT) method 1
		int numberOfSteps = (int) (Double.parseDouble(value)/0.5); 		
		for(int i=0; i<numberOfSteps; i++) {
			pressKey(sliderLocator, Keys.ARROW_RIGHT); 			
		}
		log.info("Slider is moved to " + value);

		// Move slider with sendKeys(Keys.ARROW_RIGHT) method 2
		WebElement range = find(rangeLocator);
		
		while (!((Double.parseDouble(range.getText()))==(Double.parseDouble(value)))){
			pressKey(sliderLocator, Keys.ARROW_RIGHT);	
			//System.out.println("String range is " + range.getText());
			//System.out.println("Double range is " + Double.parseDouble(range.getText()));
		}
		log.info("Slider is moved to " + value);

	}
	
	public String getSliderValue() {
		String value = find(rangeLocator).getText(); 
		log.info("Slider value is " + value);
		return value; 
	}
}
