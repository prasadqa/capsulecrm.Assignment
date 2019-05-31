package com.capsulecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.base.TestBase;
import com.capsulecrm.utill.CapsuleUtils;

import sun.awt.windows.WBufferStrategy;



public class AccountSettingsPage extends TestBase{
	
	//Object repository for Account Setting pages and Its functionalities
	
	@FindBy(xpath="//h4[text()='Account information']")
	private WebElement validateAcc;
	
	@FindBy(linkText="Account")
	private WebElement account;

	@FindBy(linkText="Invoices")
	private WebElement invoices;
	
	@FindBy(linkText="Export")
	private WebElement export;
	
	@FindBy(linkText="Appearance")
	private WebElement appearance;
	
	@FindBy(linkText="Mail Drop Box")
	private WebElement mailDropBox;
	
	@FindBy(linkText="Users")
	private WebElement users;
	
	@FindBy(xpath="//a[@href='/settings/opportunities']")
	private WebElement opportunities;
	
	@FindBy(linkText="Tracks")
	private WebElement tracks;
	
	@FindBy(linkText="Task Categories")
	private WebElement taskCategories;
	
	@FindBy(linkText="Custom Fields")
	private WebElement customFields;
	
	@FindBy(linkText="Tags")
	private WebElement tags;
	
	@FindBy(linkText="Integrations")
	private WebElement integrations;
	
	@FindBy(linkText="Trash")
	private WebElement trash;
	
	//Account,Export,Appearance,Mail Drop Box,Users,Tracks,Task Categories,Custom Fields,Tags,Integrations,Trash
	@FindBy(xpath="//*[@class='settings-page-header']")
	private WebElement commonElement1;
	
	//only for invoices and opportunities
	@FindBy(xpath="//*[@class='page-box-header']")
	private WebElement commonElement2;
	
	//file upload elements in  Appearance
	@FindBy(xpath = "//input[@type='file']")
	private WebElement imageUpload;
	
	@FindBy(xpath = "//a[text()='Save']")
	private WebElement imageSaveBtn;
	
	@FindBy(xpath = "//div[@id='appearance:logoDecorate']//div[@class='prop']/child::label")
	private WebElement imageVarify;
	
	//Add new user elements
	@FindBy(linkText = "Add new User")
	private WebElement AddNewUser;
	
	
	@FindBy(id = "register:firstnameDecorate:firstName")
	private WebElement firstName;

	@FindBy(id = "register:lastNameDecorate:lastName")
	private WebElement lastName;
	
	@FindBy(id = "register:emailDecorate:email")
	private WebElement emailAdd;
	
	@FindBy(id = "register:usernameDecorate:username")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement inviteUser;
	
	@FindBy(xpath="//table[@class='recordList']//tbody//tr")
	private WebElement tableRows;
	
	//Add new mile stones in Opportunities 
	@FindBy(xpath = "//button[text()='Add new Milestone']")
	private WebElement AddNewMileStone;
	
	@FindBy(xpath = "//input[@class='form-input-text milestone-modal-name']")
	private WebElement mileStoneName;
	
	@FindBy(xpath = "//input[@class='form-input-text milestone-modal-probability']")
	private WebElement mileStoneprob;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement mileStoneSavebtn;
	
	@FindBy(xpath = "//table[@class='record-list']//tbody//tr")
	private WebElement mileStoneTableRows;
	
	////Add new tracks stones in tracks 

	@FindBy(xpath = "//a[text()='Add new Track']")
	private WebElement addNewTracks;
	
	@FindBy(xpath="//input[@id='j_id123:trackDescriptionDecorate:trackDescription']")
	private WebElement trackName;
	
	@FindBy(xpath="//table[@id='j_id123:taskLines']//tbody//tr//td[2]//input[@class='js-task-description task-description']")
	private WebElement taskName;
	
	@FindBy(xpath ="//a[text()='Save']")
	private WebElement saveTracks;
	
	@FindBy(xpath="//table[@id='taskgroups:searchresults']//tbody//tr//td[1]")
	private WebElement trackTable;
	
	//Add new category in task category
	
	@FindBy(xpath="//a[@id='j_id124:j_id126']")
	private WebElement addNewCategory;
	
	@FindBy(xpath = "//input[@id='editCategoryForm:taskCategoryNameDecorate:taskCategoryName']")
	private WebElement categoryName;
	
	@FindBy(xpath="//input[@class='btn-primary']")
	private WebElement categorySave;
	
	@FindBy(xpath="//table[@id='j_id124:stages']//tbody//tr")
	private WebElement categoryTable;
	
	//Add tags and Data tags in tags 
	
	@FindBy(xpath="//a[@id='j_id125:j_id127']")
	private WebElement addNewTag;
	
	@FindBy(xpath="//input[@id='j_id177:tagNameDecorate:tagName']")
	private WebElement tagName;
	
	@FindBy(xpath="//input[@class='btn-primary singlesubmit']")
	private WebElement tagSavebtn;
	
	@FindBy(xpath="//table[@id='j_id125:tags']//tbody//tr//td[1]")
	private WebElement tagNameValidate;
	
	////verify all configure buttons in integrations
	
	@FindBy(xpath="//h2[@class='settings-page-header']")
	private WebElement validateIntegration;
	
	//Clean up code for tags
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteTags;
	
	@FindBy(xpath="//input[@id='j_id171:j_id172']")
	private WebElement deleteBtnTagsPopup;
	
	//Clean up code for  task category
	
	private String categoryNameClean ;
	@FindBy(xpath="//input[@name='j_id150:j_id151']")
	private WebElement deleteBtnCategotyPopup;
	
	
	//Clean up code for tracks
	
	@FindBy(xpath="//table[@id='taskgroups:searchresults']//tbody//tr//td[4]//a")
	private WebElement deleteTracks;
	
	@FindBy(xpath="//input[@id='j_id146:j_id147']")
	private WebElement deleteBtnTracksPopup;
		
	//Clean up code for  User
	
	private String userNameclean ;
	@FindBy(xpath="//a[text()='Delete user']")
	private WebElement deleteUser;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteUserPopup;
	
	
	//initializing the page factories
	public AccountSettingsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//validate the Account settings page
	public boolean validatePage()
	{
		CapsuleUtils.expliciteWait(10, validateAcc);
		return validateAcc.isDisplayed();
	}
	
	// Validate Appearance page functionality 
	public boolean validateAppearanceSubPage() throws Exception
	{
		boolean flog=false;
		appearance.click();
		String expText = appearance.getText(); 
		String accText = commonElement1.getText();
		if (expText.equalsIgnoreCase(accText)) {
			imageUpload.click();
			CapsuleUtils.fileUpload(properties.getProperty("imagePath"));
			imageSaveBtn.click();
			CapsuleUtils.expliciteWait(10, imageVarify);
			if (imageVarify.isDisplayed()) {
				flog = true;
			}
			
		}
		return flog;
	}
	// Validate User page functionality 
	public boolean validateUserSubPage(String fName,String lName,String eMail,String uName) throws Exception
	{
		userNameclean=fName+" "+lName;
		boolean flog=false;
		users.click();
		String expText = users.getText(); 
		String accText = commonElement1.getText();
		if (expText.equalsIgnoreCase(accText)) {
			AddNewUser.click();
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			emailAdd.sendKeys(eMail);
			userName.sendKeys(uName);
			CapsuleUtils.expliciteWait(10, inviteUser);
			inviteUser.click();
			CapsuleUtils.expliciteWait(10, tableRows);
			List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class='recordList']//tbody//tr"));
			//System.out.println(listOfRows.size());
			for (int i = 1; i <= listOfRows.size(); i++) {
				String actUserName = driver.findElement(By.xpath("//table[@class='recordList']//tbody//tr["+i+"]//td[2]")).getText();
				//System.out.println(actUserName);
				String expUserName = uName;
				//System.out.println(uName);
				if (expUserName.equalsIgnoreCase(actUserName)) {
					flog = true;
					break;
				}
			}
		}
		return flog;
	}

	// Validate Opportunity page functionality 
	public boolean validateOpportunitiesSubPage(String mStoneName,String probNumber) throws Exception
	{
		boolean flog=false;
		opportunities.click();
		String expText = opportunities.getText(); 
		String accText = commonElement2.getText();
		if (expText.equalsIgnoreCase(accText)) {
			AddNewMileStone.click();
			mileStoneName.sendKeys(mStoneName+probNumber);
			mileStoneprob.sendKeys(probNumber);
			CapsuleUtils.expliciteWait(10, mileStoneSavebtn);
			mileStoneSavebtn.click();
			Thread.sleep(500);
			CapsuleUtils.expliciteWait(10, mileStoneTableRows);
			List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class='record-list']//tbody//tr"));
			//System.out.println(listOfRows.size());
			for (int i = 1; i <= listOfRows.size(); i++) {
				String actUserName = driver.findElement(By.xpath("//table[@class='record-list']//tbody//tr["+i+"]//td//button[@class='hyperlink-button milestone-item-edit']")).getText();
				//System.out.println(actUserName);
				String expUserName = mStoneName+probNumber;
				//System.out.println(expUserName);
				if (expUserName.equalsIgnoreCase(actUserName)) {
					flog = true;
					break;
				}
			}
		}
		return flog;
	}
	// Validate Tracks page functionality 
	public boolean validateTracksSubPage(String trName,String tsName) throws Exception
	{
		boolean flog=false;
		tracks.click();
		String expText = tracks.getText(); 
		String accText = commonElement1.getText();
		if (expText.equalsIgnoreCase(accText)) {
			addNewTracks.click();
			trackName.sendKeys(trName);
			taskName.sendKeys(tsName);
			imageSaveBtn.click();
			CapsuleUtils.expliciteWait(10, trackTable);
			
			if (trName.equalsIgnoreCase(trackTable.getText())) {
				flog = true;
			}
			
		}
		return flog;
	}
	// Validate Task category page functionality 
	public boolean validateTaskCategorySubPage(String cotName) throws Exception
	{
		categoryNameClean = cotName;
		boolean flog=false;
		taskCategories.click();
		String expText = taskCategories.getText(); 
		String accText = commonElement1.getText();
		if (expText.equalsIgnoreCase(accText)) {
			addNewCategory.click();
			CapsuleUtils.expliciteWait(10, categoryName);
			categoryName.sendKeys(cotName);
			CapsuleUtils.expliciteWait(10, categorySave);
			categorySave.click();
			Thread.sleep(500);
			CapsuleUtils.expliciteWait(10, categoryTable);
			List<WebElement> listOfcategory =  driver.findElements(By.xpath("//table[@id='j_id124:stages']//tbody//tr"));
			//System.out.println(listOfcategory.size());
			for (int i = 1; i < listOfcategory.size(); i++) {
				String actUserName = driver.findElement(By.xpath("//table[@id='j_id124:stages']//tbody//tr["+i+"]//td[2]")).getText();
				//System.out.println(actUserName);
				String expUserName = cotName;
				//System.out.println(expUserName);
				if (expUserName.equalsIgnoreCase(actUserName)) {
					flog = true;
					break;
				}
			}
		}
		return flog;
	}
	// Validate Tags page functionality 
	public boolean validateTagsSubPage(String tName) throws Exception
	{
		boolean flog=false;
		tags.click();
		String expText = tags.getText(); 
		String accText = commonElement1.getText();
		if (accText.contains(expText)) {
			addNewTag.click();
			CapsuleUtils.expliciteWait(10, tagName);
			tagName.sendKeys(tName);
			CapsuleUtils.expliciteWait(10, tagName);
			tagSavebtn.click();
			CapsuleUtils.expliciteWait(10, tagNameValidate);
			if (tName.equalsIgnoreCase(tagNameValidate.getText())) {
				flog = true;
			}
		}
		return flog;
	}
	// Validate integrations page functionality 
	public boolean validateIntegrationsSubPage() throws Exception
	{
		int count;
		boolean flog=false;
		integrations.click();
		String expText = integrations.getText();
		String actText = commonElement1.getText();
		if (expText.equalsIgnoreCase(actText)) {
			List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='j_id124:searchresults']//tbody//tr"));
			//System.out.println(listOfElements.size());
			for (int i = 1; i <= listOfElements.size(); i++) {
				String expTextElement = driver.findElement(By.xpath("//table[@id='j_id124:searchresults']//tbody//tr["+i+"]//td//strong[text()]")).getText();
				driver.findElement(By.xpath("//table[@id='j_id124:searchresults']//tbody//tr["+i+"]//td//a[text()='Configure']")).click();
				String actTextElement = validateIntegration.getText();
				//System.out.println(expTextElement+"........"+i+"....."+actTextElement);
				if (actTextElement.contains(expTextElement)) {
					flog = true;
					integrations.click();
				}
				else{
					flog = false;
					break;
				}
				
			}
		}
				
		
		return flog;
	}
	
	//clean up method clearing tags which is created by automated scripts
	public void clearTags()
	{
		if (tagNameValidate.isDisplayed()) {
			CapsuleUtils.expliciteWait(10, deleteTags);
			deleteTags.click();
			CapsuleUtils.expliciteWait(10,deleteBtnTagsPopup);
			deleteBtnTagsPopup.click();
		}
		else{
			System.out.println("tags are not created");
		}
		
	}
	
	
	////clean up method clearing task category which is created by automated scripts
		public void clearTaskCategory() throws Exception
		{
			Thread.sleep(500);
			if (categoryTable.isDisplayed()) {
				List<WebElement> list = driver.findElements(By.xpath("//table[@id='j_id124:stages']//tbody//tr"));
				System.out.println(list.size());
				for (int i = 1; i <= list.size(); i++) {
					if (categoryNameClean.equalsIgnoreCase(driver.findElement(By.xpath("//table[@id='j_id124:stages']//tbody//tr["+i+"]//td[2]//a[text()]")).getText())) {
						driver.findElement(By.xpath("//table[@id='j_id124:stages']//tbody//tr["+i+"]//td[3]//a")).click();
						CapsuleUtils.expliciteWait(10, deleteBtnCategotyPopup);
						deleteBtnCategotyPopup.click();
						break;
					}
				}
			}
			else{
				System.out.println("categoty are not created");
			}
		}
		
		//clean up method clearing Tracks which is created by automated scripts
		public void clearTracks()
		{
			if (trackTable.isDisplayed()) {
				CapsuleUtils.expliciteWait(10, deleteTracks);
				deleteTracks.click();
				CapsuleUtils.expliciteWait(10,deleteBtnTracksPopup);
				deleteBtnTracksPopup.click();
			}
			else{
				System.out.println("Tracks not created");
			}
			
		}
		
		////clean up method clearing Users which is created by automated scripts
				public void clearUser() throws Exception
				{
					CapsuleUtils.expliciteWait(10, tableRows);
					if (tableRows.isDisplayed()) {
						List<WebElement> list = driver.findElements(By.xpath("//table[@class='recordList']//tbody//tr"));
						System.out.println(list.size());
						for (int i = 1; i <=list.size(); i++) {
								Thread.sleep(500);
								System.out.println(userNameclean);
								
							if (userNameclean.equalsIgnoreCase(driver.findElement(By.xpath("//table[@class='recordList']//tbody//tr["+i+"]//td[1]//a")).getText())) {
								System.out.println(userNameclean+"-------"+driver.findElement(By.xpath("//table[@class='recordList']//tbody//tr["+i+"]//td[1]//a")).getText());
								driver.findElement(By.xpath("//table[@class='recordList']//tbody//tr["+i+"]//td[1]//a")).click();
								CapsuleUtils.expliciteWait(10, deleteUser);
								deleteUser.click();
								CapsuleUtils.expliciteWait(10, deleteUserPopup);
								deleteUserPopup.click();
								break;
								
							}
							else{
								System.out.println("Names missMatch");
							}
						}
					}
					else{
						System.out.println("User are not created");
					}
				}
		// Validate all links present in account setting 
		public boolean validateAccountPage() 
		{
			boolean flog;
			account.click();
			if(account.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateInvaoicePage() 
		{
			boolean flog;
			invoices.click();
			if(invoices.getText().equalsIgnoreCase(commonElement2.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateExportPage() 
		{
			boolean flog;
			export.click();
			if(export.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateAppearancePage() 
		{
			boolean flog;
			appearance.click();
			if(appearance.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateMailDropBoxPage() 
		{
			boolean flog;
			mailDropBox.click();
			if(mailDropBox.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateUsersPage() 
		{
			boolean flog;
			users.click();
			if(users.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateOpportunitiesPage() 
		{
			boolean flog;
			opportunities.click();
			if(opportunities.getText().equalsIgnoreCase(commonElement2.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateTracksPage() 
		{
			boolean flog;
			tracks.click();
			if(tracks.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateTaskCategoriesPage() 
		{
			boolean flog;
			taskCategories.click();
			if(taskCategories.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateCustomFieldsPage() 
		{
			boolean flog;
			customFields.click();
			if(customFields.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateTagsPage() 
		{
			boolean flog;
			tags.click();
			if(commonElement1.getText().contains(tags.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateIntegrationsPage() 
		{
			boolean flog;
			integrations.click();
			if(integrations.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
		public boolean validateTrashPage() 
		{
			boolean flog;
			trash.click();
			if(trash.getText().equalsIgnoreCase(commonElement1.getText()));
			{
				flog = true;
			}
			return flog;
		}
				
				
		
		
}
