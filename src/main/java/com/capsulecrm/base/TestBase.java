package com.capsulecrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.capsulecrm.utill.CapsuleUtils;
import com.capsulecrm.utill.GenerateExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static GenerateExtentReport generateExtentReport ;
	public static ExtentReports report;
	public static ExtentTest tests;
	public static WebDriver driver;
	private final static String filePath = System.getProperty("user.dir")+"//src//main//java//com//capsulecrm//config//confige.properties";
	public static Properties properties;
	public static FileInputStream fis;
	private static String browserName =  null;
	
	//loading properties file
	public TestBase() 
	{
		
		try {
			fis = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// browser initialization
	public static void Initialization() throws Exception
	{
		browserName = properties.getProperty("Browser");
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else
			if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else{
				Reporter.log(browserName +" is invalid");
				throw new Exception("invalid browser name");
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicityWait")), TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

	}
	//web driver instance close method
	public static void driverQuit()
	{
		if (driver!=null) {
			driver.quit();
		}
	}
	
	// taking screen shot for fail test cases only
	public static void screenshot(String testName)
	{
		File screens = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dstFile = new File(System.getProperty("user.dir")+"//screenShots//"+testName+CapsuleUtils.getdate()+".png");
		try {
			FileUtils.copyFile(screens, dstFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	// initiating customize extent reports
	@BeforeSuite
	public void setUpReport()
	{
		generateExtentReport = new GenerateExtentReport();
		report = generateExtentReport.getInstance();
	}
	//closing extent report and flush
	@AfterSuite
	public void reportsFlush(){
	
		report.flush();
	}
}
