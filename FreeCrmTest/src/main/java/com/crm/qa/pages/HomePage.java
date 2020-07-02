package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//span[.='Gaurav Sharma']")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactBtn;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickonContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink()
	{
		contactsLink.click();
		newContactBtn.click();
	}

	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

}
