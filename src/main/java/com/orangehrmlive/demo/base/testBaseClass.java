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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;
import com.orangehrmlive.demo.pages.homePage;
import com.orangehrmlive.demo.pages.loginPage;

public class testBaseClass {
	
	
	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		
	}
	
	static long time=System.currentTimeMillis();
	String propsfilepath=System.getProperty("user.dir")+"\\properties\\Globalproperties.properties";
	static String errordestfilePath=System.getProperty("user.dir")+"\\Screenshots\\Error"+time+".png";
	String browser=System.getProperty("browser");
	
	
	
	public DesiredCapabilities dc;
	public static WebDriver driver;
	public FileInputStream fs;
	
	
	Properties props=new Properties();
	loginPage lPage=new loginPage(driver);
	homePage hPage=new homePage(driver);
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		
		try {
			fs=new FileInputStream(propsfilepath);
			props.load(fs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			dc=DesiredCapabilities.chrome();
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setCapability(CapabilityType.PLATFORM, "windows");
			driver=new ChromeDriver(dc);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else {
			dc=DesiredCapabilities.firefox();
			dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			dc.setCapability(CapabilityType.PLATFORM, "windows");
			driver=new FirefoxDriver(dc);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeTest
	public void loginOrgangeHRM() {
		
		driver.get(props.getProperty("URL"));
		waitforElementCLickable(lPage.getUserName());
		lPage.getUserName().sendKeys(props.getProperty("userName"));
		lPage.getPassWOrd().sendKeys(props.getProperty("passWord"));
		lPage.getLoginBtn().click();
		waitforElementCLickable(hPage.getDashBoardlink());
		if(!hPage.getDashBoardlink().isDisplayed()) {
			takeScreenshot();
			System.out.println("login Failed and Screenshot is captured under file : "+errordestfilePath);
		}
	}
	
	public static void waitforElementCLickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
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
	public static void takeScreenshot() {
		try {
			File destFile = new File(errordestfilePath);
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
