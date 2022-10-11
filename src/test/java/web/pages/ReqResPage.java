package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class ReqResPage extends CommonUtility {
	WebDriver driver;
	
	public ReqResPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		addImplicitWait();
		driver.get("https://reqres.in/");
		
	}
	
}
