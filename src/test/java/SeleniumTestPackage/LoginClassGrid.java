package SeleniumTestPackage;

import org.testng.annotations.Test;

import Pages.LoginPage;
import SeleniumBaseClass.BaseClassGrid;

public class LoginClassGrid extends BaseClassGrid{
	
	String userName=System.getProperty("userName");
	String passWord=System.getProperty("passWord");
	
	@Test
	public void testlogin() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setuserName(userName);
		loginpage.setPassword(passWord);
		loginpage.clickLogin();
		loginpage.verifyDashboard();
	}

}
