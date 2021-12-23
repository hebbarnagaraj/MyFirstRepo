package com.orangehrmlive.demo.TestSuites;

import org.testng.annotations.Test;

import com.orangehrmlive.demo.jobManagementTests.addJobTitle;
import com.orangehrmlive.demo.jobManagementTests.getJobTitlesAndCatagaories;

public class TestList_JobManagement {

	
	@Test
	public void testuserManagementsuite() throws Exception {
		
		System.out.println("================jobManagement Add Job Title===============");
		addJobTitle jobtitle = new addJobTitle();
		jobtitle.addjobTitles();
		
		System.out.println("================jobManagement Get job Title and category===============");
		getJobTitlesAndCatagaories jobcategory = new getJobTitlesAndCatagaories();
		jobcategory.getjobTitles();
		jobcategory.getjobCatagories();
	}
}
