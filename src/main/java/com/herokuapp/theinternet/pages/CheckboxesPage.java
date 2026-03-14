package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePage {

	private By checkbox1Locator = By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][1]");
	private By checkbox2Locator = By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][2]");
	private By listCheckboxesLocator = By.xpath("//form[@id='checkboxes']/input[@type='checkbox']");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void clickCheckbox1() {
		log.info("Select checkbox 1");
		click(checkbox1Locator);
	}

	public void clickCheckbox2() {
		log.info("Select checkbox 2");
		click(checkbox2Locator);
	}

	public void clickAllCheckboxes() {
		log.info("Selecting all checkboxes");
		List<WebElement> listCheckboxes = findAll(listCheckboxesLocator);
		for (WebElement checkbox : listCheckboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click(); // will use generic click method here. Do not need to use click method from
									// BasePage.
				// click(listCheckboxesLocator);
			}
		}
	}

	public boolean areAllCheckboxesChecked() {
		log.info("Verifying all checkboxes are checked");
		List<WebElement> listCheckboxes = findAll(listCheckboxesLocator);
		for (WebElement checkbox : listCheckboxes) {
			if (!checkbox.isSelected()) {
				return false;
			}					
		}
		return true;
	}

	public boolean isCheckbox1Checked() {
		return isChecked(checkbox1Locator);
	}

	public boolean isCheckbox2Checked() {
		return isChecked(checkbox2Locator);
	}

}
