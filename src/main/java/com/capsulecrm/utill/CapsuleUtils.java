package com.capsulecrm.utill;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capsulecrm.base.TestBase;

public class CapsuleUtils extends TestBase {

	private static String date;
	private static WebDriverWait wait;
	private static Robot robot;
	
	// generate date 
	public static String getdate()
	{
		
		Calendar calendar = Calendar.getInstance();
		Date timeAndDate = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
		date = sdf.format(timeAndDate);
		return date;
		
	}
	// explicit wait
	public static void expliciteWait(int timeOut,WebElement e)
	{
		wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	// file upload functionality
	public static void fileUpload(String filePath) throws AWTException
	{
		robot = new Robot(); 
		
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.setAutoDelay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.setAutoDelay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
