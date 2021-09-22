package SeleniumBaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassGrid {
	
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
			
			try {
				DesiredCapabilities capabilitieschrome = DesiredCapabilities.chrome();
				capabilitieschrome.setCapability(CapabilityType.BROWSER_NAME,"chrome");
				driver=new RemoteWebDriver(new URL("http://192.168.204.175:4444/wd/hub"),capabilitieschrome);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		else {
			
			try {
				DesiredCapabilities capabilitiesfirefox = DesiredCapabilities.firefox();
				capabilitiesfirefox.setCapability(CapabilityType.BROWSER_NAME,"firefox");
				driver=new RemoteWebDriver(new URL("http://192.168.204.175:4444/wd/hub"),capabilitiesfirefox);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
