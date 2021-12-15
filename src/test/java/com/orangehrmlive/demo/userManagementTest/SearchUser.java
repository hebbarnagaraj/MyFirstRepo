package com.orangehrmlive.demo.userManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.userManagement;

public class SearchUser extends testBaseClass{
	
	
	String searchUserName=System.getProperty("searchUserName");
	userManagement umPage;
	
	
	@Test
	public void testsearchUser() throws Exception {
		umPage=new userManagement(driver);
		umPage.getAdmintag().click();
		Thread.sleep(10000);
		waitforElementCLickable(umPage.getUserManagementtag());
		umPage.getUserManagementtag().click();
		waitforElementCLickable(umPage.getUserNametag());
		umPage.getUserNametag().sendKeys(searchUserName);
		umPage.getSearchBtn().click();
		Thread.sleep(10000);
		if(umPage.getTableUserNametag().isDisplayed()) {
			System.out.println("Search user Success");
		}
		else {
			takeScreenshot();
			Assert.fail();
		}
	}

}
