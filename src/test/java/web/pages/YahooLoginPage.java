package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class YahooLoginPage extends CommonUtility {
	
	WebDriver driver;
	
	public YahooLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login-username")
	private WebElement loginusername;
	
	@FindBy(id = "login-signin")
	private WebElement loginsignin;
	
	@FindBy(xpath = "//label[@for = \"persistent\"]")
	private WebElement staySignedInCheckBox;
	
	public void enterUsername() {
		loginusername.clear();
		loginusername.sendKeys("nice_ramchandra");
	}
	
	public void uncheckStaySignedIn() {
		staySignedInCheckBox.click();
	}
	
	public SelectOptionPage clickNext() throws InterruptedException {
		loginsignin.click();
		Thread.sleep(2000);
		return new SelectOptionPage(driver);
	}
	

}
