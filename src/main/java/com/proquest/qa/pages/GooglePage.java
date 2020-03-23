package com.proquest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proquest.qa.base.TestBase;

public class GooglePage extends TestBase {
	@FindBy(xpath="//input[@name='q']")
	WebElement searchtextfield;
	
	@FindBy(xpath="//input[@value='Google Search']")
	WebElement searchBtn;
	
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateGooglePageTitle() {
		return driver.getTitle();
	}
	
	public SearchResultsPage SearchProQuest(String text) {
		searchtextfield.sendKeys(text);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
		return new SearchResultsPage();
	}
}
