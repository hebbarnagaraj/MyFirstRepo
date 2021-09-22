package SeleniumTestPackage;

import org.testng.annotations.Test;

import Pages.LoginPage;
import SeleniumBaseClass.BaseClass;

public class LoginClass extends BaseClass{
	
	String userName=System.getProperty("userName");
	String passWord=System.getProperty("passWord");
	@Test
	public void testlogin() {
		driver.manage().deleteAllCookies();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setuserName(userName);
		loginpage.setPassword(passWord);
		loginpage.clickLogin();
		loginpage.verifyDashboard();
	}
	
}
