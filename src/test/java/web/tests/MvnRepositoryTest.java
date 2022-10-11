package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.base.BaseClass;
import web.pages.GoogleSearchResultsPage;
import web.pages.MvnSearchResultPage;

public class MvnRepositoryTest extends BaseClass {

	public GoogleSearchResultsPage searchResultsPage;
	public MvnSearchResultPage mvnSearchResultPage;

	@Test (priority = 0)
	public void mvnRepositorySearch() {
		mvnRepositoryPage.goTo();
		Assert.assertEquals(driver.getTitle(), "MVN");
	}

	@Test (priority = 1)
	public void browserStackTest() {
		browserStackPage.goTo();
		Assert.assertEquals(driver.getTitle(), "Quick Xpath");
	}

}
