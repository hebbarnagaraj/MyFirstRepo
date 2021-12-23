package com.orangehrmlive.demo.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;
import com.orangehrmlive.demo.Utils.WebDriverWaitUtils;
import com.orangehrmlive.demo.pages.homePage;
import com.orangehrmlive.demo.pages.loginPage;

import io.qameta.allure.Attachment;

public class testBaseClass {
	
	
	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		
	}
	
	static long time=System.currentTimeMillis();
	String propsfilepath=System.getProperty("user.dir")+"\\properties\\Globalproperties.properties";
	static String errordestfilePath=System.getProperty("user.dir")+"\\Screenshots\\Error"+time+".png";
	static String attachmentfilepath=System.getProperty("user.dir")+"\\Attachments\\Attachment.txt.txt";
	String browser=System.getProperty("browser");

	public static WebDriver driver;
	Properties props=new Properties();
	public FileInputStream fs;
	loginPage lPage;
	homePage hPage;
	
	
	@BeforeMethod
	public void setUp() throws Exception {

		try {
			fs=new FileInputStream(propsfilepath);
			props.load(fs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else {
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		lPage=new loginPage(driver);
		hPage=new homePage(driver);
		driver.get(props.getProperty("URL"));
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementVisible(lPage.getUserName(), driver);
		lPage.getUserName().sendKeys(props.getProperty("userName"));
		lPage.getPassWOrd().sendKeys(props.getProperty("passWord"));
		lPage.getLoginBtn().click();
		Thread.sleep(10000);
		try {
			if(hPage.getAccounlockedLink().isDisplayed() || hPage.getInvalidCred().isDisplayed()) {
				takeScreenshot();
				Assert.fail("Unable to Login to Orange HRM");
			}
		} catch (Exception e) {
			System.out.println("Cause is : "+e.getCause());
			e.printStackTrace();
		}
		
		
		try {
			WebDriverWaitUtils.waitforElementVisible(hPage.getDashBoardlink(),driver);
			if(!hPage.getDashBoardlink().isDisplayed()) {
				takeScreenshot();
				Assert.fail();
			}
		} catch (Exception e) {
			
		}	
	}
	
	@AfterMethod (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	@Attachment
	public static void takeScreenshot() {
		try {
			File destFile = new File(errordestfilePath);
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, destFile);
			System.out.println("Screemshot stored at location : "+errordestfilePath);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectByindex(WebElement element , int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element , String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByvisibleText(WebElement element , String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public static void attAttachment() {
		
		try {
			Robot rb = new Robot();
			StringSelection ss = new StringSelection(attachmentfilepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
