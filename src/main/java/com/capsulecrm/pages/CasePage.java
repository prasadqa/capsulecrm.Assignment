package com.capsulecrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.capsulecrm.base.TestBase;
import com.capsulecrm.utill.CapsuleUtils;

public class CasePage extends TestBase {
	
	////Object repository for cases pages and Its functionalities
	@FindBy(linkText = "Add Case")
	private WebElement addCase;
	
	@FindBy(id = "partySearch")
	private WebElement caseRelateTo;
	
	@FindBy(id = "caseNameDecorate:name")
	private WebElement nameOfCase;
	
	@FindBy(id="tagsDecorate:tagComboBox")
	private WebElement tagName;
	
	@FindBy(xpath="//input[@id='tagsDecorate:j_id191']")
	private WebElement tagging;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveCaseBtn;
	
	@FindBy(xpath="//*[@class='entity-details-title']")
	private WebElement caseNameforvalidate;
	
	@FindBy(xpath="//*[@class='tooltipper party-tooltipper ember-view']//a[@class='ember-view']")
	private WebElement assignedPerson;
	
	@FindBy(xpath = "//a[@id='addContactLink']")
	private WebElement addAnotherContact;
	
	@FindBy(xpath = "//*[@class='tag']")
	private WebElement tags;
	
	@FindBy(xpath = "//span[@class='kase-summary-status-open']")
	private WebElement status;
	
	// initializing page factories 
	public CasePage()
	{
		PageFactory.initElements(driver, this);
	}
	 // validate cases page title 
	public String validateCasesPageTitle()
	{
		CapsuleUtils.expliciteWait(10, addCase);
		return driver.getTitle();
	}
	// creating cases
	public void createCase(String caseRelateToName,String caseName,String tName) throws InterruptedException
	{
		addCase.click();
		caseRelateTo.clear();
		caseRelateTo.sendKeys(caseRelateToName);
		Thread.sleep(1000);
		caseRelateTo.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		CapsuleUtils.expliciteWait(20, addAnotherContact);
		nameOfCase.clear();
		nameOfCase.sendKeys(caseName);
		
		tagName.clear();
		tagName.sendKeys(tName);
		tagging.click();
		CapsuleUtils.expliciteWait(20, tags);
		
		saveCaseBtn.click();
	}
	//getting cases name for validating purpose
	public String getCaseName()
	{
		CapsuleUtils.expliciteWait(10, caseNameforvalidate);
		return caseNameforvalidate.getText();
	}
	//getting cases related person name for validating purpose
	public String getAssignedPersonName()
	{
		CapsuleUtils.expliciteWait(10, assignedPerson);
		return assignedPerson.getText();
	}
	//getting cases status for validating purpose
	public String getstatusOfCase()
	{
		CapsuleUtils.expliciteWait(10, assignedPerson);
		return status.getText();
	}
	
}
