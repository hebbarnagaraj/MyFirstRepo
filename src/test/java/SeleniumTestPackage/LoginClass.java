package SeleniumTestPackage;

import org.testng.annotations.Test;

import SeleniumBaseClass.BaseClass;
import SeleniumBaseClass.LoginPage;

public class LoginClass extends BaseClass{
	
	@Test
	public void testlogin() {
		driver.manage().deleteAllCookies();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setuserName("Admin");
		loginpage.setPassword("admin123");
		loginpage.clickLogin();
		loginpage.verifyDashboard();
	}
	
}
