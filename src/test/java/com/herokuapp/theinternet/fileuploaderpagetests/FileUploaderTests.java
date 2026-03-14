package com.herokuapp.theinternet.fileuploaderpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class FileUploaderTests extends TestUtilities {	
	
	@Test(dataProvider="files")
	public void fileUploadTest(int num, String fileName) {
		log.info("Starting fileUploadTest " + num + " for " + fileName);
		
		//Open File Uploader page
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
		fileUploaderPage.openPage();
		
		//Choose file 
		fileUploaderPage.chooseFile(fileName);
		
		//Select Upload button to upload file
		fileUploaderPage.uploadFile(); 
		
		//Get confirmation
		String uploadedFileName = fileUploaderPage.getUploadedFileName(); 
		
		//Verify that file is uploaded
		Assert.assertTrue(uploadedFileName.equals(fileName), "The name of file is not correct");		
	}	

}
