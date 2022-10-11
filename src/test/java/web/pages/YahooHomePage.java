package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class YahooHomePage extends CommonUtility {
	
	WebDriver driver;
	
	public YahooHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "yschsp")
	private WebElement yahooSearchBox;
	
	@FindBy(className = "mag-glass")
	private WebElement yahooSearchButton;
	
	@FindBy(linkText = "Sign In")
	private WebElement signInLink;
	
	public void enterSearchText() {
		yahooSearchBox.clear();
		yahooSearchBox.sendKeys("ram");
	}
	
	public YahooSearchResultsPage clickSearchButton() {
		yahooSearchButton.click();
		return new YahooSearchResultsPage(driver);
	}
	
	public void goTo() {
		driver.get("https://yahoo.com");
	}
	
	public YahooLoginPage clickOnSignIn() {
		signInLink.click();
		waitForElementToBeVisibleOnNextPage(driver.findElement(By.id("login-username")));
		return new YahooLoginPage(driver);
	}
}
