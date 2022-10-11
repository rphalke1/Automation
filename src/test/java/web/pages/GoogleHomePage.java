package web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class GoogleHomePage extends CommonUtility {
	
	WebDriver driver;
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement searchbox;
	
	@FindBy(linkText = "Images")
	private WebElement imageLink;
	
	public void enterSearchCriteria(String searchText) {
		searchbox.clear();
		searchbox.sendKeys(searchText);
	}
	
	public GoogleSearchResultsPage hitEnter() {
		searchbox.sendKeys(Keys.ENTER);
		return new GoogleSearchResultsPage(driver);
	}
	
	public void clickOnImagesLink() {
		imageLink.click();
	}
	
	public void goTo() {
		addImplicitWait();
		driver.get("http://google.com");
	}
}
