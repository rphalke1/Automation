package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.base.BaseClass;

public class ReqResTest extends BaseClass {

	@Test (priority = 0)
	public void reqResTest() throws InterruptedException {
		reqResPage.goTo();
		reqResPage.waitTillPageLoads();
		reqResPage.scrollBy(1000);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Reqres");
	}

}
