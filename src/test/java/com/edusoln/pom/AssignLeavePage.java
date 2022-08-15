package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.edusoln.base.CommonFunctions;

public class AssignLeavePage extends CommonFunctions {
	
	WebDriver driver;
	
	
	 
	@FindBy(id="menu_dashboard_index") WebElement dashboard_menu;
	@FindBy(className="quickLaunge") WebElement ClickAssignleave;
	@FindBy(id="assignleave_txtEmployee_empName") WebElement emp_name;
	@FindBy(id="//div[@class='ac_results'][2]/ul/li")List<WebElement> resultname;
	@FindBy(id="assignleave_txtLeaveType") WebElement dropdown_leavetype;
	@FindBy(id="assignleave_leaveBalance") WebElement balance;
	@FindBy(id="assignleave_txtFromDate") WebElement FromDate;
	@FindBy(id="assignleave_txtToDate") WebElement ToDate;
	@FindBy(id="assignleave_txtComment") WebElement comment;
	
	Logger Log=LogManager.getLogger(AssignLeavePage.class);
	
	public AssignLeavePage(WebDriver driver) {
		this.driver=driver; //comming from runner class and this driver is for that specific class
		PageFactory.initElements(driver, this);
	}
	
	public void assignLeave() throws InterruptedException {
		Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase("Dashboard"), " text mismatch");
		System.out.println("Test is executed");
		 
		WebElement ClickAssignleave=driver.findElement(By.className("quickLaunge"));
		ClickAssignleave.click();
		emp_name.sendKeys("or");
		Thread.sleep(1000);
		List<WebElement> resultname=driver.findElements(By.xpath("//div[@class='ac_results'][2]/ul/li"));
		for(WebElement list:resultname) {
			if(list.getText().equalsIgnoreCase("Orange Test")) {
				list.click();
				break;
			}
	}
					
	dropdown_leavetype.click();
	Select select = new Select(dropdown_leavetype);
	select.selectByIndex(2);
	Log.info("Dropdown selected");
	sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", FromDate);
	FromDate.clear();
	FromDate.sendKeys("2022-07-24");
	Thread.sleep(1000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].click();", ToDate);
	ToDate.clear();
	ToDate.sendKeys("2022-07-24");
	Thread.sleep(1000);
	comment.sendKeys("leave planned");
	sleep(1000);
	
}
}






