package com.SeleniumProject.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public  Base()
	{
		 prop= new Properties();
		
		File propfile= new File(System.getProperty("user.dir") + "\\src\\main\\java\\Config\\Config.properties");
		
		dataprop = new Properties();
		File datapropfile= new File(System.getProperty("user.dir") + "\\\\src\\\\main\\\\java\\\\Config\\testData.properties");
		try {
		FileInputStream fis1= new FileInputStream(datapropfile);
		dataprop.load(fis1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();

		}


		try {
		FileInputStream fis= new FileInputStream(propfile);
		prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
	public WebDriver  intializeDriver()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
