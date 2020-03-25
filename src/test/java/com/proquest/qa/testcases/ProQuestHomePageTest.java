package com.proquest.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(ProQuestHomePageTest.class);
	
	public ProQuestHomePageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setup(String browserName) throws InterruptedException {
		log.info("**********************************Task2 START*************************************");
		init(browserName);
		googlePage = new GooglePage();
		searchResultsPage = googlePage.SearchProQuest("ProQuest");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	@Parameters({"browserName"})
	public void task2(String browserName) throws InterruptedException, AWTException, IOException {
		proQuestHomePage = searchResultsPage.clickOnProQuestLink();
		Reporter.log("Clicked on Proquest link,");
		if(proQuestHomePage.isPopupPresent()) {
			proQuestHomePage.acceptPopup();
			Reporter.log("accepted popup,");
			proQuestHomePage.searchForQA("QA");
			Reporter.log("Searched for 'QA',");
		}	
		else {
			proQuestHomePage.searchForQA("QA");
			Reporter.log("Searched for 'QA',");
		}
		
		driver.switchTo().defaultContent();
		util.screenshotWithDate(browserName);
		Reporter.log("Task 2 Success and the screenshot is saved inside folder 'Results' of the current project");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		log.info("**********************************Task2 END*************************************");
	}
}
