package SeleniumBaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassGrid {
	
	String browser = System.getProperty("browser");
	String URL=System.getProperty("URL");
	public WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"SeleniumProject\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"SeleniumProject\\Drivers\\geckodriver.exe");
	}
	@BeforeMethod
	public void setup() {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			try {
				DesiredCapabilities capabilitieschrome = DesiredCapabilities.chrome();
				capabilitieschrome.setCapability(CapabilityType.BROWSER_NAME,"chrome");
				driver=new RemoteWebDriver(new URL(URL),capabilitieschrome);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		else {
			
			try {
				DesiredCapabilities capabilitiesfirefox = DesiredCapabilities.firefox();
				capabilitiesfirefox.setCapability(CapabilityType.BROWSER_NAME,"firefox");
				driver=new RemoteWebDriver(new URL(URL),capabilitiesfirefox);
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
