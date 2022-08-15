package com.edusoln.base;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edusoln.utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {

	
	public static WebDriver driver;
	public static String homepath = System.getProperty("user.dir");
	static String FoLderpath;
	
	static long wait_time=Long.parseLong(PropertyReader.getProperty(Constants.WAIT));

	public static WebDriver brouserLaunch(String brousername) {

		switch (brousername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	public static String getScreenshot(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;// downcastng
		File src = ts.getScreenshotAs(OutputType.FILE);// take a screenshot
		Date date = new Date(0);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy HH_mm");
		String FormatedDate = dateformat.format(date);
		System.out.println("FormatedDate");
		FoLderpath = homepath + "\\src\\test\\Resources\\Screenshot\\" + FormatedDate;
		File target = new File(FoLderpath + "\\" + screenshotname + ".png");
		String destination = FoLderpath + "\\" + screenshotname + ".png";
		// Files.copy(src, target);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;

	}

	public static void getScreenshot(WebElement element, String Screenshotname) throws IOException {
		File headerScrn = element.getScreenshotAs(OutputType.FILE);

		File target = new File(FoLderpath + "\\" + Screenshotname + ".png ");
		FileUtils.copyFile(headerScrn, target);
	}
	
	public static void visibilityOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(wait_time))    ;
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void visibilityOfListElement(List<WebElement> element) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(wait_time))    ;
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    
    
    public static void cickElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(wait_time))    ;
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    

	public static String GetStringData(Object obj) {
		return obj.toString();
		
	}
	
	public static void sleep(long time ) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}











