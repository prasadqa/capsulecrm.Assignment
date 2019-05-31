package com.capsulecrm.utill;


import com.capsulecrm.utill.ExcelUtils;

import org.testng.annotations.DataProvider;

// Data getting from excel to dataprovider annotation 
public class ExcelDataProvider 
{
	private ExcelUtils excel;
	private Object[][] excelData = null;
	
	public Object[][] testData(String sheetName) throws Exception
	{
		excel = new ExcelUtils();
		int numberOfRow = excel.getRowCount(sheetName);
		int numberOfCol = excel.getColCount(sheetName, 0);
		excelData = new Object[numberOfRow][numberOfCol];
		for (int i = 1; i <= numberOfRow; i++) 
		{
			int numberOfColumns = excel.getColCount(sheetName, i);
			for (int j = 0; j < numberOfColumns; j++) {
				excelData[i-1][j]=excel.getCelldata(sheetName, i, j);
			}
		}
		return excelData;
		
	}
	
	// data provider method instance and respective sheets 
	
	@DataProvider(name="persons")
	public static Object[][] personsData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("PersonData");
	}
	@DataProvider(name="cases")
	public static Object[][] casesData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("CaseData");
	}
	@DataProvider(name="AddUsers")
	public static Object[][] addUsersData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("AddUserData");
	}
	@DataProvider(name="MileStone")
	public static Object[][] addMileStoneData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("MileStone");
	}
	
	//TracksData
	@DataProvider(name="TracksData")
	public static Object[][] addTracksData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("TracksData");
	}
	
	@DataProvider(name="TaskCategory")
	public static Object[][] addTaskCategoryData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("TaskCategory");
	}
	
	@DataProvider(name="TagName")
	public static Object[][] addTagsData() throws Exception
	{
		ExcelDataProvider Data = new ExcelDataProvider();
		return Data.testData("TagName");
	}
}
