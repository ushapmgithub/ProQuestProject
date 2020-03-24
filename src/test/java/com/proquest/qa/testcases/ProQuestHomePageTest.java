package com.proquest.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.proquest.qa.base.TestBase;
import com.proquest.qa.pages.GooglePage;
import com.proquest.qa.pages.ProQuestHomePage;
import com.proquest.qa.pages.SearchResultsPage;
import com.proquest.qa.util.TestUtil;

public class ProQuestHomePageTest extends TestBase {
	ProQuestHomePage proQuestHomePage;
	GooglePage googlePage;
	SearchResultsPage searchResultsPage;
	TestUtil util = new TestUtil();
	
	public ProQuestHomePageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setup(String browserName) throws InterruptedException {
		init(browserName);
		googlePage = new GooglePage();
		searchResultsPage = googlePage.SearchProQuest("ProQuest");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	@Parameters({"browserName"})
	public void task2(String browserName) throws InterruptedException, AWTException, IOException {
		proQuestHomePage = searchResultsPage.clickOnProQuestLink();
		Reporter.log("Clicked on Proquest link,",true);
		if(proQuestHomePage.isPopupPresent()) {
			proQuestHomePage.acceptPopup();
			Reporter.log("accepted popup,",true);
			proQuestHomePage.searchForQA("QA");
			Reporter.log("Searched for 'QA',",true);
		}	
		else {
			proQuestHomePage.searchForQA("QA");
			Reporter.log("Searched for 'QA',",true);
		}
		
		driver.switchTo().defaultContent();
		util.screenshotWithDate(browserName);
		Reporter.log("Task 2 Success and the screenshot is saved inside folder 'Results' of the current project",true);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
