package web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class MvnRepositoryPage extends CommonUtility {
	WebDriver driver;
	
	public MvnRepositoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "query")
	private WebElement mvnRepositorySearchBox;
	
	public void goTo() {
		addImplicitWait();
		driver.get("https://mvnrepository.com");
		System.out.println("went to MVN repository");
	}
	
	public void enterMvnSearchText() {
		mvnRepositorySearchBox.clear();
		mvnRepositorySearchBox.sendKeys("testng");
	}
	
	public MvnSearchResultPage hitEnter() {
		mvnRepositorySearchBox.sendKeys(Keys.ENTER);
		return new MvnSearchResultPage(driver);
	}
}
