package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	@FindBy(css=".fa.fa-user")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	WebElement loginOpt;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickMyAccount()
	{
		myAccountDropMenu.click();
	}

	public void loginClick()
	{
		loginOpt.click();
	}
}
