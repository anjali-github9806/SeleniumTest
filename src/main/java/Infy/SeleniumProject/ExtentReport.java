package Infy.SeleniumProject;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports reports()
	{
		
	
	ExtentReports extentReport = new ExtentReports();
	

	 ExtentReports extent = new ExtentReports();
	        // Setting up Extent Reports
	      //  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	        File report = new File(System.getProperty("user.dir")+"\\test-output\\extendreports\\extendreports.html");
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(report);
	        
	        htmlReporter.config().setTheme(Theme.DARK);
	        
	        
	        extent.attachReporter(htmlReporter);

	        // Creating a test in the report
	        return extent;
	      
	        
	    
	}

	
	}
	


