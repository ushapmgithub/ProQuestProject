package com.proquest.qa.pages;

import java.awt.AWTException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proquest.qa.base.TestBase;

public class ProQuestHomePage extends TestBase {
	@FindBy(xpath="//iframe[@title='TrustArc Cookie Consent Manager']")
	WebElement cookiesPopup;
	
	@FindBy(xpath="//a[text()='Agree and Proceed']")
	WebElement agreeCookies;
	
	@FindBy(xpath="//a[text()='Close']")
	WebElement closePopup;
	
	@FindBy(xpath="//i[@class=' fa  fa-2  fa-search ']")
	WebElement searchIcon;
	
	@FindBy(xpath="//form[@id='search-form']")
	WebElement searchBox;
	
	@FindBy(xpath="(//input[@aria-label='Search box to search entire site'])[2]")
	WebElement textField;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement searchBtn;
	
	public ProQuestHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isPopupPresent() throws InterruptedException, AWTException {
		try {
				searchIcon.isEnabled();
			}
			catch (NoSuchElementException e) {
				return false;
			}
			return true;
	}
	
	public void acceptPopup() {
		driver.switchTo().frame(cookiesPopup);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(agreeCookies)).click();
		//agreeCookies.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(closePopup)).click();
		//closePopup.click();
		driver.switchTo().defaultContent();
	}
	
	public void searchForQA(String text) {
		searchIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		textField.click();
		textField.sendKeys(text);
		searchBtn.click();
	}
}
