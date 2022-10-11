package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class YahooSearchResultsPage extends CommonUtility {
	WebDriver driver;
	
	public YahooSearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
