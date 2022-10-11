package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.base.BaseClass;
import web.pages.GoogleSearchResultsPage;

public class GoogleSearchTest extends BaseClass {

	public GoogleSearchResultsPage searchResultsPage;

	@Test (priority = 0)
	public void googleSearch() {
		googleHomePage.goTo();
		System.out.println("test1 - googleSearch");
		googleHomePage.enterSearchCriteria(getPropertyObject().getProperty("searchKeyword"));
		searchResultsPage = googleHomePage.hitEnter();
	}

	@Test (priority = 1)
	public void verifyTitle() {
		googleHomePage.goTo();
		System.out.println("test1 - verifyTitle");
		Assert.assertEquals(driver.getTitle(), getPropertyObject().getProperty("expectedGoogleTitle"));
	}

	@Test (priority = 2)
	public void googleImages() {
		googleHomePage.goTo();
		System.out.println("test1 - googleImages");
		googleHomePage.clickOnImagesLink();
		Assert.assertEquals(driver.getTitle(), getPropertyObject().getProperty("expectedGoogleImageTitle"));
	}

}
