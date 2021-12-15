package com.orangehrmlive.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;
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
		waitforElementVisible(lPage.getUserName());
		lPage.getUserName().sendKeys(props.getProperty("userName"));
		lPage.getPassWOrd().sendKeys(props.getProperty("passWord"));
		lPage.getLoginBtn().click();
		Thread.sleep(10000);
		if(hPage.getInvalidCred().isDisplayed()) {
			takeScreenshot();
			Assert.fail();
		}
		waitforElementVisible(hPage.getDashBoardlink());
		if(!hPage.getDashBoardlink().isDisplayed()) {
			takeScreenshot();
			Assert.fail();
		}
	}
	
	@AfterMethod (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	
	public static void waitforElementCLickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitforElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitforelementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void jsScrolltoElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void jsClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
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
}
