package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.base.BaseClass;
import web.base.RetryFailedTestcases;
import web.pages.SelectOptionPage;
import web.pages.YahooLoginPage;
import web.pages.YahooSearchResultsPage;

public class YahooSearchTest extends BaseClass {
	
	YahooSearchResultsPage yahooSearchResultsPage;
	YahooLoginPage yahooLoginPage;
	SelectOptionPage selectOptionPage;
	
	@Test (priority = 0)
	public void yahooSearcch() {
		yahooHomePage.goTo();
		yahooHomePage.enterSearchText();
		yahooSearchResultsPage = yahooHomePage.clickSearchButton();
	}

	@Test (priority = 1, retryAnalyzer = RetryFailedTestcases.class)
	public void verifyYahooTitle() {
		yahooHomePage.goTo();
		Assert.assertEquals(driver.getTitle(), "Yahoo");
	}

	@Test (priority = 2, groups = {"Login"})
	public void yahooLogin() throws InterruptedException {
		yahooHomePage.goTo();
		yahooLoginPage = yahooHomePage.clickOnSignIn();
		yahooLoginPage.enterUsername();
		yahooLoginPage.uncheckStaySignedIn();
		selectOptionPage = yahooLoginPage.clickNext();
		Boolean flag = selectOptionPage.verifyEmailAddress();
		Assert.assertTrue(flag);
	}

}
