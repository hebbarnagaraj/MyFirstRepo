package SeleniumBaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	String browser = System.getProperty("browser");
	public WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagar\\OneDrive\\Desktop\\Java\\Selenium\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nagar\\OneDrive\\Desktop\\Java\\Selenium\\Drivers\\geckodriver.exe");
	}
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		
		if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capabilitieschrome = DesiredCapabilities.chrome();
			capabilitieschrome.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			driver=new ChromeDriver(capabilitieschrome);
		}
		else {
			DesiredCapabilities capabilitiesfirefox = DesiredCapabilities.firefox();
			capabilitiesfirefox.setCapability(CapabilityType.BROWSER_NAME,"firefox");
			driver=new ChromeDriver(capabilitiesfirefox);
		}
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	public  void explicitWaitforelementvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
