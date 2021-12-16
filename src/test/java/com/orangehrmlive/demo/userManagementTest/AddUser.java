package com.orangehrmlive.demo.userManagementTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.userManagement;

public class AddUser extends testBaseClass{
	
	String userRole=System.getProperty("userRole");
	String employeeName=System.getProperty("employeeName");
	String userNametext=System.getProperty("userNametext");
	String passWord=System.getProperty("passWord");
	userManagement umPage;
	
	@Test
	public void testaddUser() throws Exception {
		umPage=new userManagement(driver);
		umPage.getAdmintag().click();
		Thread.sleep(10000);
		waitforElementCLickable(umPage.getUserManagementtag());
		umPage.getUserManagementtag().click();
		Thread.sleep(10000);
		umPage.getAddUserbtn().click();
		Thread.sleep(10000);
		selectByvisibleText(umPage.getUserRoleSelect(), userRole);
		umPage.getEmployeeNameinput().sendKeys(employeeName);
		umPage.getEmployeeNameinput().sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		umPage.getUserNameinput().sendKeys(userNametext);
		umPage.getPassWordinput().sendKeys(passWord);
		umPage.getConfirmPasswordinput().sendKeys(passWord);
		umPage.getSaveUserbtn().click();
		Thread.sleep(10000);
		try {
			if(umPage.getStrengthMeter().isDisplayed()) {
				umPage.getSaveUserbtn().click();
				Thread.sleep(10000);
			}
			if(umPage.getSearchBtn().isDisplayed()) {
				System.out.println("User is added successfully");
			}
			else {
				takeScreenshot();
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
