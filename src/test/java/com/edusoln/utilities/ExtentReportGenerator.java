package com.edusoln.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {

	public static String homepath = System.getProperty("user.dir");

	ExtentTest test;
	static ExtentReports report;

	public static ExtentReports ExtentReportSetup() {
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(
				homepath + "\\src\\test\\resources\\Reporter\\Extentreport.html");
		htmlreporter.config().setDocumentTitle("Excecute report");
		htmlreporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		return report;
	}

}
