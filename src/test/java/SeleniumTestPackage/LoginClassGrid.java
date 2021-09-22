package SeleniumTestPackage;

import org.testng.annotations.Test;

import SeleniumBaseClass.BaseClassGrid;
import SeleniumBaseClass.LoginPage;

public class LoginClassGrid extends BaseClassGrid{
	
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
