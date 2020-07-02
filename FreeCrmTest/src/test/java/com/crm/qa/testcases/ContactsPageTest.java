package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
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
		contactsPage=homePage.clickonContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
	}
	
    @Test(priority = 2)
    public void validateNewContact()
    {
    	homePage.clickOnNewContactLink();
    	contactsPage.createNewContact("James", "Wilson");
    	
    }
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
