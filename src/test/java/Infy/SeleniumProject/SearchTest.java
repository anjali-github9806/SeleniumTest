package Infy.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumProject.Base.Base;

public class SearchTest extends Base {
	
	public SearchTest()
	{
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=intializeDriver();
		
	}
	@AfterMethod
	public void teardown()
	{
		 //driver = new ChromeDriver();
		driver.quit();

	}

	@Test
	 public void verifySearchValidProduct()
	 {
		 driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("Validproduct"));
		 driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		 Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	 }
}
