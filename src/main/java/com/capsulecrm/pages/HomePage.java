package com.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.base.TestBase;

public class HomePage extends TestBase{

	//Object repository for Home page and Its functionalities
	@FindBy(xpath= "//a[@href='/parties']")
	private WebElement people;
	
	@FindBy(xpath= "//a[@aria-label='Dashboard']")
	private WebElement HomePageDashBoard;
	
	@FindBy(xpath= "//a[@href='/cases']")
	private WebElement cases;
	
	@FindBy(xpath= "//div[@class='nav-bar-account-details']")
	private WebElement AccountDetails;
	
	@FindBy(linkText = "Log out")
	private WebElement LogOut;
	
	@FindBy(linkText = "Account Settings")
	private WebElement accSettings;
	
	// initialize page factories
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// getting title of the page for validate
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	// navigating people page
	public PeoplePage navigateToPeoplePage()
	{
		people.click();
		return new PeoplePage();
	}
	// navigating Cases page
	public CasePage navigateToCasePage()
	{
		cases.click();
		return new CasePage();
	}
	
	// logOut page
	public LogInPage LogOut()
	{
		AccountDetails.click();
		LogOut.click();
		return new LogInPage();
	}
	//Navigating Accounts settings
	public AccountSettingsPage navigateToAccountSettings()
	{
		AccountDetails.click();
		accSettings.click();
		return new AccountSettingsPage();
	}

}
