package com.proquest.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proquest.qa.base.TestBase;

public class SearchResultsPage extends TestBase {
	@FindBy(xpath="//a[@href='http://www.proquest.com/']")
	WebElement proquestWebsite;
	
	@FindBy(xpath="//h3[@class='LC20lb DKV0Md']|//div[@class='zTpPx']")
	List<WebElement> allSearchResults;
	
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> resultTitles() {
		return allSearchResults;
	}
	
	public ProQuestHomePage clickOnProQuestLink() {
		proquestWebsite.click();
		return new ProQuestHomePage();
	}
}
