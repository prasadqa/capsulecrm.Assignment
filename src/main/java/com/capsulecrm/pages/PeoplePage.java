package com.capsulecrm.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.capsulecrm.base.TestBase;
import com.capsulecrm.utill.CapsuleUtils;

import sun.net.www.content.image.png;

public class PeoplePage extends TestBase{
	
	
	//Object repository for login page and Its functionalities
	@FindBy(linkText="Add Person")
	private WebElement addPerson;
	
	@FindBy(name="party:j_id108:j_id116")
	private WebElement title;
	
	@FindBy(id="party:fnDecorate:fn")
	private WebElement firstName;
	
	@FindBy(id="party:lnDecorate:ln")
	private WebElement lastName;
	// party:j_id325:0:phnDecorate:number
	@FindBy(id="party:j_id325:0:phnDecorate:number")
	private WebElement phoneNumber;
	
	@FindBy(id= "party:j_id342:0:emlDecorate:nmbr")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='party:save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//a[@class='ember-view']")
	private WebElement personsNames;
	
	//initialize page factories
	public PeoplePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// getting title for validate 
	public String getTitlePeoplePage()throws Exception
	{
		CapsuleUtils.expliciteWait(20, addPerson);
		//System.out.println(driver.getTitle());
		return driver.getTitle();
		
	}
	
	// creating person 
	public String createPerson(String prefix,String fName,String lName,String pNumber,String eMail)
	{
		addPerson.click(); 
		//System.out.println(prefix+fName+lName+pNumber+eMail);
		//title.clear();
		Select select = new Select(title);
		select.selectByValue(prefix);
		
		firstName.clear();
		firstName.sendKeys(fName);
		
		lastName.clear();
		lastName.sendKeys(lName);
		
		phoneNumber.clear();
		phoneNumber.sendKeys(pNumber);
		
		emailId.clear();
		emailId.sendKeys(eMail);
		
		saveBtn.click();
		
		String personName = fName+" "+lName;
		return personName;
		
	}
	// getting person name for validate  
	public List personsNames()
	{
		//ArrayList<String> names = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='ember-view']"));
		//System.out.println(list.size());
		
		return list;
	}
	
	

}
