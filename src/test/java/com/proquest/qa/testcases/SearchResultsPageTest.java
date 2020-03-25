package com.proquest.qa.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.proquest.qa.base.TestBase;
import com.proquest.qa.pages.GooglePage;
import com.proquest.qa.pages.ProQuestHomePage;
import com.proquest.qa.pages.SearchResultsPage;
import com.proquest.qa.util.TestUtil;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class SearchResultsPageTest extends TestBase {
	GooglePage googlePage;
	SearchResultsPage searchResultsPage;
	ProQuestHomePage proQuestHomePage;
	TestUtil util = new TestUtil();
	Logger log = Logger.getLogger(SearchResultsPageTest.class);
	
	public SearchResultsPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setup(String browserName) {
		log.info("**********************************Task1 START*************************************");
		init(browserName);
		googlePage = new GooglePage();
		searchResultsPage = googlePage.SearchProQuest("ProQuest");
	}
	
	@Test(priority=1)
	@Parameters({"browserName"})
	public void task1(String browserName) throws IOException {
		List<WebElement> allResults = searchResultsPage.resultTitles();
		Reporter.log("Listed all the search Results of the web page,");
		util.writeToFile(allResults, browserName);
		Reporter.log("Task1 is success and the text file is saved inside the folder 'Results' of the current project");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		log.info("**********************************Task1 END*************************************");
	}
}
