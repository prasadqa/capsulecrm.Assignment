package com.capsulecrm.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.capsulecrm.base.TestBase;
import com.capsulecrm.pages.CasePage;
import com.capsulecrm.pages.HomePage;
import com.capsulecrm.pages.LogInPage;
import com.capsulecrm.pages.PeoplePage;
import com.capsulecrm.utill.CapsuleUtils;

public class CasesPageTest extends TestBase {

	public String currentMethodName;
	LogInPage logInPage;
	HomePage homePage;
	PeoplePage peoplePage;
	CasePage casePage;
	SoftAssert softAssert;
	
	public CasesPageTest()
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
		casePage = new CasePage();
		softAssert = new SoftAssert();
		logInPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		homePage.navigateToCasePage();
		
	}
	@Test(priority=1)
	public void varifyCasesPageTitle()
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Cases Page title");
		Assert.assertEquals(casePage.validateCasesPageTitle(), properties.getProperty("casesPageTitle"));
		Reporter.log("varified case page title");
		tests.info(MarkupHelper.createLabel( currentMethodName+"Page title test", ExtentColor.BLUE));
	}
	
	@Test(priority=2,dataProvider ="cases",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class )
	public void varifyCreateCases(String caseRelateToName,String caseName,String tName) throws InterruptedException
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Create ceases test");
		casePage.createCase(caseRelateToName, caseName, tName);
		Reporter.log("cases created");
		tests.info(MarkupHelper.createLabel( currentMethodName+" created ceases", ExtentColor.BLUE));
		softAssert.assertEquals(casePage.getCaseName(),caseName,"mismatch case name");
		tests.info(MarkupHelper.createLabel( currentMethodName+"cases names matched", ExtentColor.BLUE));
		Reporter.log("case name matched");
		softAssert.assertEquals(casePage.getAssignedPersonName(),caseRelateToName,"mismatch person name");
		tests.info(MarkupHelper.createLabel( currentMethodName+"person names matched", ExtentColor.BLUE));
		Reporter.log("person name matched");
		softAssert.assertEquals(casePage.getstatusOfCase(),"Open","mismatch status" );
		tests.info(MarkupHelper.createLabel( currentMethodName+"status names matched", ExtentColor.BLUE));
		Reporter.log("case name matched");
		softAssert.assertAll();
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
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
