package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class GoogleSearchResultsPage extends CommonUtility {
	WebDriver driver;
	
	public GoogleSearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
