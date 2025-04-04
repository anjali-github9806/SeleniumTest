package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void UserEmail(String EamilText)
	{
		email.sendKeys(EamilText);
	}
	
	public void UserPassword(String Pass)
	{
		password.sendKeys(Pass);
	}
	
	public void Login()
	{
		login.click();
	}

}
