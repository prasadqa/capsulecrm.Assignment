package com.capsulecrm.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.capsulecrm.base.TestBase;
import com.capsulecrm.pages.HomePage;
import com.capsulecrm.pages.LogInPage;
import com.capsulecrm.pages.PeoplePage;
import com.capsulecrm.utill.CapsuleUtils;
import com.capsulecrm.utill.ExcelDataProvider;

public class PersonPageTest extends TestBase{
	
	public String currentMethodName;
	LogInPage logInPage;
	HomePage homePage;
	PeoplePage peoplePage;
	
	
	public PersonPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		Initialization();
		logInPage = new LogInPage();
		homePage = new HomePage();
		peoplePage = new PeoplePage();
		logInPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		homePage.navigateToPeoplePage();
		
	}
	@Test(priority=1)
	public void verifyPesrsonsTitle() throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Persons Page title");
		Assert.assertEquals(peoplePage.getTitlePeoplePage(), properties.getProperty("preplePageTitle"));
		tests.info(MarkupHelper.createLabel( currentMethodName+"Page title test", ExtentColor.BLUE));
		Reporter.log("varified case page title");
	}
	@Test(priority=2,dataProvider="persons",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class)
	public void verifyAddPerson(String prefix,String fName,String lName,String pNumber,String eMail)
	{
		boolean flog = false;
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Add Persons");
		String nameOfPerson = peoplePage.createPerson(prefix, fName, lName, pNumber, eMail);
		tests.info(MarkupHelper.createLabel( currentMethodName+"New Person created", ExtentColor.BLUE));
		Reporter.log("New Person created");
		homePage.navigateToPeoplePage();
		tests.info(MarkupHelper.createLabel( currentMethodName+"Navigate to people page", ExtentColor.BLUE));
		Reporter.log("Navigate to people page");
		List<WebElement> names = peoplePage.personsNames();
		System.out.println(names.size());
		for (int i = 0; i < names.size(); i++)
		{
			String personName = names.get(i).getText();
			if (nameOfPerson.equalsIgnoreCase(personName)) {
				flog = true;
				break;
			}
		}
		Assert.assertTrue(flog);
		tests.info(MarkupHelper.createLabel( currentMethodName+"person names matched", ExtentColor.BLUE));
		Reporter.log("varified add new person");
		
	}
	@AfterMethod
	public void shutDown(ITestResult result) throws Exception
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			tests.pass(MarkupHelper.createLabel(result.getMethod().getMethodName()+" : pass", ExtentColor.GREEN));
			System.out.println(currentMethodName +": verified result Pass");
			Reporter.log(currentMethodName +" varified and pass");
		}else 
			 if(result.getStatus()==ITestResult.FAILURE){
				screenshot(result.getMethod().getMethodName());
				tests.fail(MarkupHelper.createLabel(result.getMethod().getMethodName()+" : fail", ExtentColor.RED));
				String imagePath = System.getProperty("user.dir")+"//screenShots//"+result.getMethod().getMethodName()+CapsuleUtils.getdate()+".png";
				tests.addScreenCaptureFromPath(imagePath);
				System.out.println(currentMethodName +": verified result fail");
				Reporter.log(currentMethodName+" varified and fail");
			}
			 else
				 if (result.getStatus()==ITestResult.SKIP) {

						tests.skip(MarkupHelper.createLabel(result.getMethod().getMethodName()+" : skipped", ExtentColor.BROWN));
						System.out.println(currentMethodName +": verified result fail");
						Reporter.log(currentMethodName +" varified and fail");
					
				}

		driverQuit();
	}
	
	

}
