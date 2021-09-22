package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumBaseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@id='menu_dashboard_index']")
	WebElement dashboard;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setuserName(String UserName) {
		explicitWaitforelementvisible(userName);
		userName.sendKeys(UserName);
	}
	
	public void setPassword(String passWord) {
		explicitWaitforelementvisible(Password);
		Password.sendKeys(passWord);
	}
	public void clickLogin() {
		explicitWaitforelementvisible(loginBtn);
		loginBtn.click();
	}
	public void verifyDashboard() {
		
		explicitWaitforelementvisible(dashboard);
		if(dashboard.isDisplayed()) {
			System.out.println("Dashboard is visible");
		}
		else {
			Assert.fail();
		}
	}

}
