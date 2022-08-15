package com.edusoln.runner;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.edusoln.base.CommonFunctions;
import com.edusoln.base.Constants;
import com.edusoln.pom.AssignLeavePage;
import com.edusoln.pom.LoginPage;
import com.edusoln.utilities.ExcelReader;
import com.edusoln.utilities.ExtentReportGenerator;
import com.edusoln.utilities.PropertyReader;

public class TestRunner extends CommonFunctions {
	
	static Logger log=LogManager.getLogger(TestRunner.class);

		public static WebDriver driver;
	
	public static ExtentTest test;
	ExtentReports report;
	

	@BeforeTest
	public void beforetest() {
		
		report=ExtentReportGenerator.ExtentReportSetup();
		
			}
	
	@BeforeMethod
	public void BrouserSetUp() {

		driver = CommonFunctions.brouserLaunch(PropertyReader.getProperty(Constants.BROUSER));
		driver.get(PropertyReader.getProperty(Constants.BASEURL));
	}
	
	@DataProvider (name="dp")
	public Object[][] datasupplier() throws IOException {
		
		Object[][] data = ExcelReader.excelReader();
		
			return data;
	}

	@Test(dataProvider="dp")
	public void Login(Map <Object, Object> data) {
		test=report.createTest("Login Verification");
		LoginPage login = new LoginPage(driver);
		login.login(test, data);
		test.log(Status.PASS, " Login is Succesfull");//.addScreenCaptureFromPath(CommonFunctions.getScreenshot(driver,"Loginsucces"));
	}

	@Test(enabled=true , dataProvider="dp")
	public void assignLeave(Map<Object, Object> data) throws InterruptedException  {
		test=report.createTest("leave assign verification");
		LoginPage login = new LoginPage(driver);
		login.login(test, data);
		test=report.createTest("Assign leave Login Succesful");
		AssignLeavePage assignleave = new AssignLeavePage(driver);
		assignleave.assignLeave();
		test.log(Status.PASS, "Assign leave Login is Succesfull");//.addScreenCaptureFromPath(CommonFunctions.getScreenshot(driver,"LeaveAssignsucces"));

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@AfterTest
	public void aftertest() {
		report.flush();
	}

}
