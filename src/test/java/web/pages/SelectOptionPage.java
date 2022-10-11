package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.common.CommonUtility;

public class SelectOptionPage extends CommonUtility {
	WebDriver driver;
	
	public SelectOptionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "login-box-container")
	private WebElement loginBoxContainer;
	
	public boolean verifyEmailAddress() {
		String data = loginBoxContainer.getText();
		System.out.println("email address on login box is - "+data);
		return data.contains("nice_ramchandra");
	}
}
