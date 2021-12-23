package com.orangehrmlive.demo.userManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.Utils.WebDriverWaitUtils;
import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.commanPage;
import com.orangehrmlive.demo.pages.userManagement;

public class DeleteUser extends testBaseClass{
	
	String deleteuserName=System.getProperty("deleteuserName");
	userManagement umPage=new userManagement(driver);
	commanPage cPage=new commanPage(driver);
	
	
	@Test
	public void testDeleteUser() throws Exception {
		
		cPage.getAdmintag().click();
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementCLickable(umPage.getUserManagementtag(),driver);
		umPage.getUserManagementtag().click();
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementCLickable(umPage.getUserNametag(),driver);
		umPage.getUserNametag().sendKeys(deleteuserName);
		umPage.getSearchBtn().click();
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementCLickable(umPage.getTableUserNametag(),driver);
		
		if(umPage.getSelectTabelusercheckbox().isDisplayed()) {
			umPage.getSelectTabelusercheckbox().click();
			umPage.getDeleteUserbtn().click();
			WebDriverWaitUtils.waitforElementCLickable(umPage.getConfirmDeletebtn(),driver);
			umPage.getConfirmDeletebtn().click();
			Thread.sleep(10000);
			if(cPage.getAdmintag().isDisplayed()) {
				System.out.println("Delete User Succuess");
			}
		}
		else {
			takeScreenshot();
			Assert.fail();
		}
	}

}
