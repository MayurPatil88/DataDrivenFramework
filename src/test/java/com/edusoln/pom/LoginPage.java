package com.edusoln.pom;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage {

	

	WebDriver driver;
	
	@FindBy(id = "txtUsername") WebElement userid;
	@FindBy(id = "txtPassword") WebElement password;
	@FindBy(id = "btnLogin") WebElement Login_button;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; //comming from runner class and this driver is for that specific class
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void login(ExtentTest test, Map<Object, Object> data) {
		
		userid.sendKeys(data.get("UserId").toString());
		test.log(Status.PASS, "user id enter");
		password.sendKeys(data.get("password").toString());
		test.log(Status.PASS, "password is enter");
		Login_button.click();
		test.log(Status.INFO,"Login is successful" );
	}
	
}
