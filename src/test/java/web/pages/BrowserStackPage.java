package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class BrowserStackPage extends CommonUtility {
	WebDriver driver;
	
	public BrowserStackPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		addImplicitWait();
		driver.get("https://www.browserstack.com/guide/xpath-locators-cheat-sheet");
		System.out.println("went to browser stack site");
	}
}
