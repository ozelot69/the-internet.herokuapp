package com.herokuapp.theinternet.horizontalslidertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSlider;

public class HorizontalSliderTests extends TestUtilities {
	
	@Test	
	public void sliderTest() {
		log.info("Starting sliderTest"); 
		
		//Open Horizontal slider page
		HorizontalSlider horizontalSlider = new HorizontalSlider(driver, log); 
		horizontalSlider.openPage();
		
		//Move slider horizontically
		String value = "3.0";
		horizontalSlider.moveSliderTo(value);
		
		//Verify that slider is moved to the correct position 
		String sliderValue = horizontalSlider.getSliderValue(); 
		Assert.assertTrue((Double.parseDouble(sliderValue))==(Double.parseDouble(value)), "Range is not correct") ;		
		
	}

}
