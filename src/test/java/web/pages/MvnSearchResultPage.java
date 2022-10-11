package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class MvnSearchResultPage extends CommonUtility {
	WebDriver driver;
	
	public MvnSearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "TestNG")
	private WebElement testNGlinkText;
	
	public Boolean verifySearchOnMvn() {
		return (testNGlinkText.getText()).contains("TestNG");
	}
}
