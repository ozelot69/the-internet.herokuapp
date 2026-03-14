package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage{
	
	String pageUrl = "http://the-internet.herokuapp.com/upload"; 
	
	private By chooseFileBtnLocator = By.id("file-upload"); 
	private By uploadBtnLocator = By.id("file-submit"); 
	private By uploadedFileLocator = By.id("uploaded-files"); 
	
	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public void openPage() {
		log.info("Open page " + pageUrl); 
		super.openPage(pageUrl);
		log.info("Page opened...");
	}
	
	public void chooseFile(String fileName) {	
		log.info("Choose file");		 
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, chooseFileBtnLocator);
		log.info("Selected file: " + fileName);
	}	
	
	public void uploadFile() {
		log.info("Upload file");	
		click(uploadBtnLocator); 
	}
	
	public String getUploadedFileName() {
		return find(uploadedFileLocator).getText(); 
	}	

}
