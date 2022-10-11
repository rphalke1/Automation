package web.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import web.common.CommonUtility;
import web.config.ExtentReporterNG;
import web.pages.BrowserStackPage;
import web.pages.GoogleHomePage;
import web.pages.MvnRepositoryPage;
import web.pages.ReqResPage;
import web.pages.YahooHomePage;

public class BaseClass extends ExtentReporterNG {

	public WebDriver driver;
	public GoogleHomePage googleHomePage;
	public YahooHomePage yahooHomePage;
	public MvnRepositoryPage mvnRepositoryPage;
	public ReqResPage reqResPage;
	public BrowserStackPage browserStackPage;

	public WebDriver initializeDriver(String browserName) {
		if (driver == null) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeTest (alwaysRun = true)
	public void launchApplication() {
		driver = initializeDriver(System.getProperty("browser")!=null ? System.getProperty("browser") : getPropertyObject().getProperty("browser"));
		googleHomePage = new GoogleHomePage(driver);
		yahooHomePage = new YahooHomePage(driver);
		mvnRepositoryPage = new MvnRepositoryPage(driver);
		reqResPage = new ReqResPage(driver);
		browserStackPage = new BrowserStackPage(driver);
		
	}

	@AfterTest (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		String path = CommonUtility.getScreenshotPath(testCaseName);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(source, file);
		return path;
		
		
	}

}
