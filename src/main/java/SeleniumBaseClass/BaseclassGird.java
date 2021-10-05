package SeleniumBaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseclassGird {
	
	
	 public WebDriver driver;
//	 String browser=System.getProperty("browser");
//	 String URL=System.getProperty("URL");
	 
	 static {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		}
	
	@Parameters({"browser","URL"})
	@BeforeMethod
	public void setup(String browser, String URL) {
		DesiredCapabilities capschrome = DesiredCapabilities.chrome();
		if(browser.equalsIgnoreCase("chrome")) {
			
			try {
				driver=new RemoteWebDriver(new URL(URL), capschrome);
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			DesiredCapabilities capsfox = DesiredCapabilities.firefox();
			try {
				driver=new RemoteWebDriver(new URL(URL), capsfox);
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
