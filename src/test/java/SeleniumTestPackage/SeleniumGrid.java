package SeleniumTestPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import SeleniumBaseClass.BaseclassGird;

public class SeleniumGrid extends BaseclassGird{
	
//	String userName=System.getProperty("userName");
//	String passWord=System.getProperty("passWord");
	
	@Parameters({"userName","passWord"})
	@Test
	public void testlogin(String userName, String passWord) throws Exception {
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(20000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setuserName(userName);
		loginpage.setPassword(passWord);
		loginpage.clickLogin();
		Thread.sleep(20000);
		loginpage.verifyDashboard();
	}

}
