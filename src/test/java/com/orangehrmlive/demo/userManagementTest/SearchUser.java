package com.orangehrmlive.demo.userManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.Utils.WebDriverWaitUtils;
import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.commanPage;
import com.orangehrmlive.demo.pages.userManagement;

public class SearchUser extends testBaseClass{
	
	
	String searchUserName=System.getProperty("searchUserName");
	userManagement umPage=new userManagement(driver);
	commanPage cPage=new commanPage(driver);;
	
	
	@Test
	public void testsearchUser() throws Exception {
		cPage.getAdmintag().click();
		Thread.sleep(10000);
		WebDriverWaitUtils.waitforElementCLickable(umPage.getUserManagementtag(),driver);
		umPage.getUserManagementtag().click();
		WebDriverWaitUtils.waitforElementCLickable(umPage.getUserNametag(),driver);
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
