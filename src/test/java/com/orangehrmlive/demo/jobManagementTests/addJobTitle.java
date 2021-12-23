package com.orangehrmlive.demo.jobManagementTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.Utils.ActionUtils;
import com.orangehrmlive.demo.Utils.WebDriverWaitUtils;
import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.commanPage;
import com.orangehrmlive.demo.pages.jobTitle;

public class addJobTitle extends testBaseClass{
	
	String JobTitle=System.getProperty("JobTitle");
	String JobDescription=System.getProperty("JobDescription");
	String note=System.getProperty("note");
	jobTitle jobPage;
	commanPage cPage;
	
	@Test
	public void addjobTitles() throws Exception {
		jobPage=new jobTitle(driver);
		cPage=new commanPage(driver);
		
		cPage.getAdmintag().click();
		Thread.sleep(10000);
		
		ActionUtils.mouseHoverAction(driver, jobPage.getJoblink());
		Thread.sleep(3000);
		jobPage.getJobtitleLink().click();
		WebDriverWaitUtils.waitforElementCLickable(cPage.getAddUserbtn(), driver);
		cPage.getAddUserbtn().click();
		jobPage.getJobTitletext().sendKeys(JobTitle);
		jobPage.getJobDescriptiontext().sendKeys(JobDescription);
		jobPage.getJobTitle_note().sendKeys(note);
		jobPage.getChoseFilebutton().click();
		attAttachment();
		cPage.getSaveUserbtn().click();
		Thread.sleep(10000);
		if(!jobPage.getJobtitleverifyEle().isDisplayed()) {
			takeScreenshot();
			Assert.fail();
		}
		
	}
	

}
