package com.herokuapp.theinternet.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//we can add listeners here
@Listeners({com.herokuapp.theinternet.base.TestListener.class}) 

public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {// ITestContext is an
																							// interface that defines a
																							// test context
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();

		driver.manage().window().maximize();
		
		//assign values to our class level variables 
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();

//		System.out.println("Create driver: " + browser);
//
//		switch (browser) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//
//		default:
//			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
//			driver = new ChromeDriver();
//			break;
//		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// System.out.println("Close driver");
		log.info("Close driver");
		driver.quit();
	}

}
