package com.herokuapp.theinternet.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	protected void openPage(String pageUrl) {
		driver.get(pageUrl);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	// Click on element with given locator when it is visible
	protected void click(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).click();
	}

	// Type given text into element with given locator when it is visible
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).sendKeys(text);
	}

	// Wait for specific ExpectedCondition for the given amount of time in seconds
	private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
		timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}

	// Wait for given number of seconds for element with given locator to be visible
	// on the page
	protected void waitForVisibilityOf(By locator, Duration... timeOut) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOut.length > 0 ? timeOut[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	// Wait for given number of seconds for element with given locator to be
	// clickable
	protected void waitElementToBeClickable(By locator, Duration... timeOut) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.elementToBeClickable(locator), (timeOut.length > 0 ? timeOut[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	// Wait for alert present and then switch to alert
	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	// Switch to the new window
	protected void switchToWindow(String expectedTitle) {
		String originalWindowHandle = driver.getWindowHandle();		
		Set<String> allWindowHandles = driver.getWindowHandles();		
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);
				if (getCurrentPageTitle().equals(expectedTitle))
					break;
			}
		}
	}

	// Switch to iFrame using its locator
	protected void swithToFrame(By frameLocator) {
		// WebElement iFrame = find(frameLocator);
		driver.switchTo().frame(find(frameLocator));
	}

	// Press key on locator
	protected void pressKey(By locator, Keys key) {
		find(locator).sendKeys(key);
	}

	// Press key using Actions class - can be used from any class
	public void pressKeyWithActions(Keys key) {
		log.info("Pressing " + key.name() + " using Actions class");
		Actions actions = new Actions(driver);
		actions.sendKeys(key).build().perform();
	}

	// Scroll to the bottom of the page using JavaScriptExecutor
	public void scrollToPageBottom() {
		log.info("Scrolling to the bottom of the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Scroll to an element using JavaScriptExecutor
	protected void scrollToElementView(By locator) {
		WebElement element = find(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Drag and Drop source element to target element
	public void performDragAndDrop(By from, By to) {
		// using Actions
		// Actions actions = new Actions(driver);
		// actions.dragAndDrop(find(from), find(to)).build().perform();

		// using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", find(from), find(to));
	}

	
	// HoverOver element
	protected void hoverOver(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	
	 //Move slider horizontically using normal method
	protected void setSliderTo(By locator, int xOffSet) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(find(locator), xOffSet, 0).build().perform();		
	}
	
	
	

	// Mine methods...

	protected boolean isChecked(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		if (find(locator).isSelected()) {
			return true;
		}
		return false;
	}

	protected boolean isDisplayed(By locator) {
		try {
			waitForVisibilityOf(locator, Duration.ofSeconds(5));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	protected String getMsg(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		driver.switchTo().defaultContent();
		return find(locator).getText();

	}

	// Wait for element with given locator to be clickable
//		protected void waitElementToBeClickable(By locator) {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.elementToBeClickable(locator));
//		}

}
