package Infy.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SeleniumProject.Base.Base;
import com.qa.PageObjects.HomePage;
import com.qa.PageObjects.LoginPage;
import com.seleniumProject.Utility.Utilities;

@Test
public class loginTest extends Base {
	WebDriver driver;
	Utilities util = new Utilities();
	String mail= util.RandomEmail();
	public loginTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
	//	loadProprtyFile();
		driver=intializeDriver();
		HomePage home = new HomePage(driver);

		home.ClickMyAccount();
		home.loginClick();
		//driver.findElement(By.linkText("Login")).click();
		
	}
	@AfterMethod
	public void teardown()
	{
	
		driver.quit();

	}
    @Test(priority=1 , dataProvider="supplyTestData")
	public void validate(String email , String password)
	{
		 
		//driver.close();
    	LoginPage log = new LoginPage(driver);
    	log.UserEmail(email);
    	log.UserPassword(password);
    	log.Login();
		//driver.findElement(By.id("input-email")).sendKeys(email);
	//	driver.findElement(By.id("input-password")).sendKeys(password);
	//	driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		//Assert.assertTrue(false, null)
		
	
	}
    @Test(priority=2)
    public void InvalidCredLogin()
    {
    	 
		driver.findElement(By.id("input-email")).sendKeys(mail);
		driver.findElement(By.id("input-password")).sendKeys("Akshay8794");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String val=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String exceptedWaringMessage = dataprop.getProperty("InvalidMessage");
		Assert.assertEquals(val, exceptedWaringMessage);    	
    }
    
     @Test(priority=3)
    public void InvalidEmailLogin()
    {
    	 
		driver.findElement(By.id("input-email")).sendKeys(mail);
		driver.findElement(By.id("input-password")).sendKeys("Akshay8794");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String val=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String exceptedWaringMessage = dataprop.getProperty("InvalidMessage");
		Assert.assertEquals(val, exceptedWaringMessage); 
    	
    }
    
     @Test(priority=4)
    public void InvalidEmailandcredLogin()
    {
    	
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String val=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String exceptedWaringMessage = dataprop.getProperty("InvalidMessage");
		Assert.assertEquals(val, exceptedWaringMessage);   	
    }
     @DataProvider
     public Object[][] supplyTestData()
     {
    	 Object [][] data = Utilities.getTestDataFromExcelSheet("Sheet1");
    	 //Utilities.get
    	 return data;
     }
}
