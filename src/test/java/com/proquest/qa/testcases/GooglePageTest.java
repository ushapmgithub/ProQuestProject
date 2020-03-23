package com.proquest.qa.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.proquest.qa.base.TestBase;
import com.proquest.qa.pages.GooglePage;
import com.proquest.qa.pages.SearchResultsPage;

import junit.framework.Assert;

public class GooglePageTest extends TestBase {
	GooglePage googlePage;
	SearchResultsPage searchResultsPage;
	
	public GooglePageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setup(String browserName) {
		init(browserName);	
		googlePage = new GooglePage();
	}
	
	@Test(priority=0)
	public void googlePageTitleTest() {
		String actualTitle = googlePage.validateGooglePageTitle();
		Assert.assertEquals(actualTitle, "Google");
		Reporter.log("Navigated to Google Page,",true);
	}
	
	@Test(priority=1)
	public void searchResultsTest() {
		searchResultsPage = googlePage.SearchProQuest("ProQuest");
		Reporter.log("Entered the text 'ProQuest' in the search text field,",true);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
