package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePage {

	String pageUrl = "http://the-internet.herokuapp.com/javascript_error";

	public JSErrorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		log.info("Open page " + pageUrl);
		super.openPage(pageUrl);
		log.info("Page opened...");
	}

}
