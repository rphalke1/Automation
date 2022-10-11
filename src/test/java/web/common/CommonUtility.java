package web.common;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonUtility(WebDriver driver) {
		this.driver = driver;
	}

	public static String getReportPath() {
		return System.getProperty("user.dir")+"\\reports\\report.html";
	}
	
	public static String getScreenshotPath(String testcaseName) {
		return System.getProperty("user.dir") + "//reports//screenshots//" + testcaseName + CommonUtility.getDateAndTime() +".png";
	}
	
	public static String getDateAndTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datentime = formatter.format(now);
		datentime = datentime.replace("/", "");
		datentime = datentime.replace(" ", "");
		datentime = datentime.replace(":", "");
		return datentime;
	}
	
	public void scrollBy(double pixel) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,1000)");
	}
	
	public void waitTillPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	public void addImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElementToBeVisibleOnNextPage(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
