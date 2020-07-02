package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","HomePage Title not matched");
		
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws Throwable
	{
		contactsPage=homePage.clickonContactsLink();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
