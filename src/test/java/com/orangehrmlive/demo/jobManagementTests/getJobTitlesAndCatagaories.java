package com.orangehrmlive.demo.jobManagementTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.orangehrmlive.demo.Utils.ActionUtils;
import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.pages.commanPage;
import com.orangehrmlive.demo.pages.jobTitle;

public class getJobTitlesAndCatagaories extends testBaseClass{
	
	
	jobTitle jobPage=new jobTitle(driver);
	commanPage cPage=new commanPage(driver);
	
	@Test
	public void getjobTitles() throws Exception {

		cPage.getAdmintag().click();
		Thread.sleep(10000);
		
		ActionUtils.mouseHoverAction(driver, jobPage.getJoblink());
		Thread.sleep(3000);
		jobPage.getJobtitleLink().click();
		Thread.sleep(3000);
		List<WebElement> alljobTitles = jobPage.getResultTable();
		
		System.out.println("Total Number of Jobs is :"+alljobTitles.size());
		System.out.println("====================================================");
		System.out.println("Job titles are :");
		for(WebElement jobtitle:alljobTitles) {
			jobtitle.getText();
		}
		System.out.println("====================================================");
		
	}
	
	@Test
	public void getjobCatagories() throws Exception {
		cPage.getAdmintag().click();
		Thread.sleep(10000);
		
		ActionUtils.mouseHoverAction(driver, jobPage.getJoblink());
		Thread.sleep(3000);
		
		jobPage.getJobCegoryLink().click();
		Thread.sleep(3000);
		List<WebElement> alljobCategorues = jobPage.getResultTable();
		System.out.println("Total Number of Jobs categories  :"+alljobCategorues.size());
		
		System.out.println("====================================================");
		System.out.println("Job categories are :");
		for(WebElement jobCategory:alljobCategorues) {
			jobCategory.getText();
		}
		System.out.println("====================================================");
				
		
	}

}
