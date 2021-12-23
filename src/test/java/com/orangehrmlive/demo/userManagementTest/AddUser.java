package com.orangehrmlive.demo.userManagementTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.Utils.WebDriverWaitUtils;
import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.commanPage;
import com.orangehrmlive.demo.pages.userManagement;

public class AddUser extends testBaseClass{
	
	String userRole=System.getProperty("userRole");
	String employeeName=System.getProperty("employeeName");
	String userNametext=System.getProperty("userNametext");
	String passWord=System.getProperty("passWord");
	userManagement umPage=new userManagement(driver);
	commanPage cPage=new commanPage(driver);
	
	@Test
	public void testaddUser() throws Exception {
		
		cPage.getAdmintag().click();
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementCLickable(umPage.getUserManagementtag(),driver);
		umPage.getUserManagementtag().click();
		Thread.sleep(10000);
		cPage.getAddUserbtn().click();
		Thread.sleep(10000);
		selectByvisibleText(umPage.getUserRoleSelect(), userRole);
		umPage.getEmployeeNameinput().sendKeys(employeeName);
		umPage.getEmployeeNameinput().sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		umPage.getUserNameinput().sendKeys(userNametext);
		umPage.getPassWordinput().sendKeys(passWord);
		umPage.getConfirmPasswordinput().sendKeys(passWord);
		cPage.getSaveUserbtn().click();
		Thread.sleep(10000);
		try {
			if(umPage.getStrengthMeter().isDisplayed()) {
				cPage.getSaveUserbtn().click();
				Thread.sleep(10000);
			}
			if(umPage.getSearchBtn().isDisplayed()) {
				System.out.println("User is added successfully");
			}
			else {
				takeScreenshot();
				Assert.fail("Unable to add user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
