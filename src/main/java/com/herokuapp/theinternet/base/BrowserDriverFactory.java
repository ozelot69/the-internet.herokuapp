package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); 
	private String browser; 
	protected Logger log;
	
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase(); 
		this.log = log; 
	}
	
	public WebDriver createDriver() {		
		//System.out.println("Create driver: " + browser);
		
		log.info("Create driver: " + browser); 
		
		switch (browser) {
		case "chrome":
			//WebDriver chromeDriver = new ChromeDriver(); // Create a new instance of ChromeDriver
			driver.set(new ChromeDriver()); // Store the WebDriver instance in the ThreadLocal variable
			break;

		case "firefox":
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get(); 
	}	
	

}
