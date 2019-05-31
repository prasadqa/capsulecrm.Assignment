package com.capsulecrm.tests;

import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.capsulecrm.base.TestBase;
import com.capsulecrm.pages.AccountSettingsPage;
import com.capsulecrm.pages.CasePage;
import com.capsulecrm.pages.HomePage;
import com.capsulecrm.pages.LogInPage;
import com.capsulecrm.pages.PeoplePage;
import com.capsulecrm.utill.CapsuleUtils;

public class AccountSettingsPageTest extends TestBase 
{
	public String currentMethodName;
	LogInPage logInPage;
	HomePage homePage;
	PeoplePage peoplePage;
	CasePage casePage;
	SoftAssert softAssert;
	AccountSettingsPage accountSettingsPage;
	
		
		
	
	
	public AccountSettingsPageTest()
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
		accountSettingsPage = new AccountSettingsPage();
		logInPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		homePage.navigateToAccountSettings();
		
	}
	@Test(priority=1)
	public void varifyAccPage()
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Accounts Page title");
		Assert.assertTrue(accountSettingsPage.validatePage());
		tests.info(MarkupHelper.createLabel("Page title tests", ExtentColor.BLUE));
		
	}
	@Test(priority = 2)
	public void verifyAllSubPages()
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify all sub pages in Accounts Page");
		
		softAssert.assertTrue((accountSettingsPage.validateAccountPage()));
		Reporter.log("AccountPage varified");
		tests.info(MarkupHelper.createLabel("validate Account Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateInvaoicePage());
		Reporter.log("InvaoicePage varified");
		tests.info(MarkupHelper.createLabel("validate Invaoice Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateExportPage());
		Reporter.log("ExportPage varified");
		tests.info(MarkupHelper.createLabel("validate Export Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateAppearancePage());
		Reporter.log("AppearancePage varified");
		tests.info(MarkupHelper.createLabel("validate Appearance Page", ExtentColor.BLUE));
		
		
		softAssert.assertTrue(accountSettingsPage.validateMailDropBoxPage());
		Reporter.log("MailDropBoxPage varified");
		tests.info(MarkupHelper.createLabel("validate MailDropBox Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateUsersPage());
		Reporter.log("UsersPage varified");
		tests.info(MarkupHelper.createLabel("validate Users Page", ExtentColor.BLUE));
		
		
		softAssert.assertTrue(accountSettingsPage.validateAccountPage());
		Reporter.log("OpportunitiesPage varified");
		tests.info(MarkupHelper.createLabel("validate Opportunities Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateTracksPage());
		Reporter.log("TracksPage varified");
		tests.info(MarkupHelper.createLabel("validate Tracks Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateTaskCategoriesPage());
		Reporter.log("TaskCategoriesPage varified");
		tests.info(MarkupHelper.createLabel("validate TaskCategories Page", ExtentColor.BLUE));
		
		
		softAssert.assertTrue(accountSettingsPage.validateCustomFieldsPage());
		Reporter.log("CustomFieldsPage varified");
		tests.info(MarkupHelper.createLabel("validate CustomFileds Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateTagsPage());
		Reporter.log("TagsPage varified");
		tests.info(MarkupHelper.createLabel("validate Tags Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateIntegrationsPage());
		Reporter.log("IntegrationsPage varified");
		tests.info(MarkupHelper.createLabel("validate Integrations Page", ExtentColor.BLUE));
		
		softAssert.assertTrue(accountSettingsPage.validateTrashPage());
		Reporter.log("TrashPage varified");
		tests.info(MarkupHelper.createLabel("validate Trash Page", ExtentColor.BLUE));
		
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void verifyAppearancePage() throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Appearance Page");
		Assert.assertTrue(accountSettingsPage.validateAppearanceSubPage());
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Appearance Page tests", ExtentColor.BLUE));
	}
	//Verify the add users 
	@Test(priority=4,dataProvider="AddUsers",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class )
	public void verifyUserPage(String fName,String lName,String eMail,String uName) throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Users Page");
		Assert.assertTrue(accountSettingsPage.validateUserSubPage(fName, lName, eMail, uName));
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Users Page tests", ExtentColor.BLUE));
	}
	@Test(priority=5,dataProvider="MileStone",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class,retryAnalyzer= com.capsulecrm.listeners.RetryListener.class)
	public void verifyOpportunitiesPage(String mStoneName,String probNumber) throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Opportunity Page");
		Assert.assertTrue(accountSettingsPage.validateOpportunitiesSubPage(mStoneName, probNumber));
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Opportunity Page tests", ExtentColor.BLUE));
	}
	@Test(priority=6,dataProvider="TracksData",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class)
	public void verifyTracksPage(String trName,String tsName) throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Tracks Page");
		Assert.assertTrue(accountSettingsPage.validateTracksSubPage(trName, tsName));
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Tracks Page tests", ExtentColor.BLUE));
	}
	@Test(priority=7,dataProvider="TaskCategory",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class)
	public void verifyTaskCategoryPage(String cotName) throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Task category Page");
		Assert.assertTrue(accountSettingsPage.validateTaskCategorySubPage(cotName));
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Task category Page tests", ExtentColor.BLUE));
	}
	@Test(priority=8,dataProvider="TagName",dataProviderClass=com.capsulecrm.utill.ExcelDataProvider.class)
	public void verifyTagsPage(String tagName) throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Tags Page");
		Assert.assertTrue(accountSettingsPage.validateTagsSubPage(tagName));
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Tags Page tests", ExtentColor.BLUE));
	}
	@Test(priority = 9)
	public void verifyIntegrationsPage() throws Exception
	{
		currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		tests = report.createTest(currentMethodName,"Verify Integration Page");
		Assert.assertTrue(accountSettingsPage.validateIntegrationsSubPage());
		Reporter.log(currentMethodName);
		tests.info(MarkupHelper.createLabel("Integrations Page tests", ExtentColor.BLUE));
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result)throws Exception
	{
		
		if (result.getMethod().getMethodName().equalsIgnoreCase("verifyTagsPage")) {
			accountSettingsPage.clearTags();
			tests.info(MarkupHelper.createLabel("Clean Up for Tags Page", ExtentColor.BLUE));
		}
		else 
			if(result.getMethod().getMethodName().equalsIgnoreCase("verifyTaskCategoryPage")){
			
				accountSettingsPage.clearTaskCategory();
				tests.info(MarkupHelper.createLabel("Clean Up for Task Category Page", ExtentColor.BLUE));
			}
			else 
				if(result.getMethod().getMethodName().equalsIgnoreCase("verifyTracksPage")){
				
					accountSettingsPage.clearTracks();
					tests.info(MarkupHelper.createLabel("Clean Up for Tracks Page", ExtentColor.BLUE));
				}
				else 
					if(result.getMethod().getMethodName().equalsIgnoreCase("verifyUserPage")){
					
						accountSettingsPage.clearUser();
						tests.info(MarkupHelper.createLabel("Clean Up for Users Page", ExtentColor.BLUE));
					}
					else{
						System.out.println("No clean Up code");
					}
		
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
