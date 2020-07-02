package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase 
{
   @FindBy(xpath="//div[@class='ui header item mb5 light-black']")
   WebElement contactsLabel;
   
   @FindBy(name="first_name")
   WebElement firstName;
   
   @FindBy(name="last_name")
   WebElement lastName;
   
   @FindBy(xpath="//button[@class='ui linkedin button']")
   WebElement saveBtn;
   
   
   public ContactsPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public boolean verifyContactsLabel()
   {
	   return contactsLabel.isDisplayed();
   }
   
   public void createNewContact(String fname,String lname)
   {
	   firstName.sendKeys(fname);
	   lastName.sendKeys(lname);
	   driver.findElement(By.xpath("//div[@name='status']")).click();
	   driver.findElement(By.xpath("//div[@name='status']//div[3]")).click();
	   saveBtn.click();
   }

}
