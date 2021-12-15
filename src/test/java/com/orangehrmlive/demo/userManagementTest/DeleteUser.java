package com.orangehrmlive.demo.userManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.userManagement;

public class DeleteUser extends testBaseClass{
	
	String deleteuserName=System.getProperty("deleteuserName");
	userManagement umPage;
	
	
	@Test
	public void testDeleteUser() throws Exception {
		umPage=new userManagement(driver);
		umPage.getAdmintag().click();
		Thread.sleep(10000);
		waitforElementCLickable(umPage.getUserManagementtag());
		umPage.getUserManagementtag().click();
		Thread.sleep(10000);
		waitforElementCLickable(umPage.getUserNametag());
		umPage.getUserNametag().sendKeys(deleteuserName);
		umPage.getSearchBtn().click();
		Thread.sleep(10000);
		waitforElementCLickable(umPage.getTableUserNametag());
		
		if(umPage.getSelectTabelusercheckbox().isDisplayed()) {
			umPage.getSelectTabelusercheckbox().click();
			umPage.getDeleteUserbtn().click();
			waitforElementCLickable(umPage.getConfirmDeletebtn());
			umPage.getConfirmDeletebtn().click();
			Thread.sleep(10000);
			if(umPage.getAdmintag().isDisplayed()) {
				System.out.println("Delete User Succuess");
			}
		}
		else {
			takeScreenshot();
			Assert.fail();
		}
	}

}
