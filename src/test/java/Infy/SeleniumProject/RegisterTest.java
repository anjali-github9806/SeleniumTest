package Infy.SeleniumProject;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.SeleniumProject.Base.Base;
import com.seleniumProject.Utility.Utilities;

public class RegisterTest extends Base{
	WebDriver driver;
	
	Utilities util = new Utilities();
	String mail= util.RandomEmail();
	public RegisterTest()
	{
		super();
	}
	@AfterMethod
	public void teardown()
	{
		 //driver = new ChromeDriver();
		driver.quit();

	}
	@Test
	public void registerlogin()
	{
		//RandomEmail ran = new RandomEmail();
		//String email = RandomEmail();
		//intializeDriver driver = new intializeDriver();
		driver=intializeDriver();
	  
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(mail);
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("mobileNo"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("passkey"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("passkey"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String val=driver.findElement(By.cssSelector("div[id='content'] h1")).getText();
		Assert.assertEquals(val, "Your Account Has Been Created!");
		
		
		
	}

	@Test
	public void ValidateExixting()
	{
		//RandomEmail ran = new RandomEmail();
		//String email = RandomEmail();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys("anjalidhumshetti9806@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("mobileNo"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("passkey"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("passkey"));
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String val=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(val, "Warning: E-Mail Address is already registered!");
		
		
		
	}
	
	@Test
	public void registerWithoutDEtails()
	{
		//RandomEmail ran = new RandomEmail();
		//String email = RandomEmail();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String val=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(val, "Warning: You must agree to the Privacy Policy!");
		
		
		
	}

}
