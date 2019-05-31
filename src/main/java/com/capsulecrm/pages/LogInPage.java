package com.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.base.TestBase;

public class LogInPage extends TestBase {

	////Object repository for login page and Its functionalities
	@FindBy(name="login:usernameDecorate:username")
	WebElement userName;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submitButton;
	
	
	//initialize page factories
	public LogInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//getting title for validate 
	public String validateGetTitle()
	{
		return driver.getTitle();
	}
	// login to application
	public HomePage login(String uName,String pword)
	{
		
		userName.clear();
		userName.sendKeys(uName);
		Password.clear();
		Password.sendKeys(pword);
		
		submitButton.click();
		
		return new HomePage();
	}
	
	
	
}
