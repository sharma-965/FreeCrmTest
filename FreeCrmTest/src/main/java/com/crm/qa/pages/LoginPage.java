package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{
// Page factory or Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="(//div[.='Login'])[2]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[.='Sign Up']")
	WebElement SignUpBtn;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public HomePage Login(String email,String pwd) throws Throwable
	{
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		
		return new HomePage();
	}
	
	
	
	
	
}
