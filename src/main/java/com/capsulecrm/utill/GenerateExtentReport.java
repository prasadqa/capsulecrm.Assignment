package com.capsulecrm.utill;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.capsulecrm.base.TestBase;

public class GenerateExtentReport extends TestBase  {
	
	private static Platform platform;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReports;
	private static String reportName =  "Test reports"+CapsuleUtils.getdate()+".html";
	private static String pathForMac = System.getProperty("user.dir")+"/ExtentReports";
	private static String pathForWindows = System.getProperty("user.dir")+"\\ExtentReports";
	private static String fileLocationMac = pathForMac+"/"+reportName;
	private static String fileLocationWindow = pathForWindows+"/"+reportName;
	
	
	
	public static ExtentReports getInstance()
	{
		if (extentReports==null) {
			extentReports = createInstance();
		}
		return extentReports;
	}
	
	public static ExtentReports createInstance()
	{
		platform = getCurrentPlatform();
		String fileName = getReportsLocation(platform);
		htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.setAppendExisting(false);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName(fileName);
		
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Testing Application URL", properties.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", properties.getProperty("Browser"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Host Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		
		extentReports.attachReporter(htmlReporter);
		
		return extentReports;
	}
	//get current platform
	private static Platform getCurrentPlatform(){
		if (platform==null) {
			
			String operatingSys = System.getProperty("os.name").toLowerCase();
			if (operatingSys.contains("win")) {
				platform = Platform.WINDOWS;
			}else 
				 if(operatingSys.contains("mac")){
					platform = Platform.MAC; 
				 }
		}
		return platform;
	}
	//creates the reports directory if it does nor exits
	private static void createReportPath(String path)
	{
		File testReports = new File(path);
		if (!testReports.exists()) {
			if (testReports.mkdir()) {
				System.out.println("Directory: " + path + " is created!" );
			}
			else{
				System.out.println("Failed to create Directory: " + path);
			}
		}
		else{
			System.out.println("Directory already exists: "+ path);
		}
	}
	//getting reports location based on Plate form
	private static String getReportsLocation(Platform platform)
	{
		String reportsFileLocation= null;
		
		switch (platform) {
		case MAC:
			reportsFileLocation = fileLocationMac;
			createReportPath(pathForMac);
			System.out.println("ExtentReport Path for MAC: " + pathForMac + "\n");
			break;
		case WINDOWS:
			reportsFileLocation = fileLocationWindow;
			createReportPath(pathForWindows);
			System.out.println("ExtentReport Path for Windows: " + pathForWindows  + "\n");
			break;	
		default:
			System.out.println("Extent report path has not been set there is a problem! \n");
			break;
		}
		
		return reportsFileLocation;
		
	}
	
	
}
