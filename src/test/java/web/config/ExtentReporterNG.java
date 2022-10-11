package web.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import web.common.CommonUtility;

public class ExtentReporterNG extends PropertiesConfiguration {
	
	public ExtentReports getReportObject()
	{
		String path =CommonUtility.getReportPath();
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", getPropertyObject().getProperty("QA"));
		extent.setSystemInfo("Environment", getPropertyObject().getProperty("environment"));
		extent.setSystemInfo("Project", getPropertyObject().getProperty("projectName"));
		return extent;
		
	}
}
