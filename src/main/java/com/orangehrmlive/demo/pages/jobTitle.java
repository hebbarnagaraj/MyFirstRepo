package com.orangehrmlive.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class jobTitle {



	@FindBy(xpath="//li//*[.='Job']")
	private WebElement joblink;

	@FindBy(xpath="//a[.='Job Titles']")
	private WebElement jobtitleLink;

	@FindBy(xpath="//*[@id='jobTitle_jobTitle']")
	private WebElement jobTitletext;

	@FindBy(xpath="//*[@id='jobTitle_jobDescription']")
	private WebElement jobDescriptiontext;

	@FindBy(xpath="//*[@id='jobTitle_jobSpec']")
	private WebElement choseFilebutton;

	@FindBy(xpath="//*[@id='jobTitle_note']")
	private WebElement jobTitle_note;

	@FindBy(xpath="//table[@id='resultTable']//a[.='Job Title']")
	private WebElement jobtitleverifyEle;

	@FindBy(xpath="//table[@id='resultTable']//tr/td//a")
	private List<WebElement> resultTable;


	@FindBy(xpath="//a[.='Job Categories']")
	private WebElement jobCegoryLink;



	public jobTitle(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public List<WebElement> getResultTable() {
		return resultTable;
	}




	public void setResultTable(List<WebElement> resultTable) {
		this.resultTable = resultTable;
	}




	public WebElement getJobCegoryLink() {
		return jobCegoryLink;
	}


	public void setJobCegoryLink(WebElement jobCegoryLink) {
		this.jobCegoryLink = jobCegoryLink;
	}




	public WebElement getJobtitleverifyEle() {
		return jobtitleverifyEle;
	}


	public void setJobtitleverifyEle(WebElement jobtitleverifyEle) {
		this.jobtitleverifyEle = jobtitleverifyEle;
	}


	public WebElement getJoblink() {
		return joblink;
	}


	public void setJoblink(WebElement joblink) {
		this.joblink = joblink;
	}


	public WebElement getJobtitleLink() {
		return jobtitleLink;
	}


	public void setJobtitleLink(WebElement jobtitleLink) {
		this.jobtitleLink = jobtitleLink;
	}


	public WebElement getJobTitletext() {
		return jobTitletext;
	}


	public void setJobTitletext(WebElement jobTitletext) {
		this.jobTitletext = jobTitletext;
	}


	public WebElement getJobDescriptiontext() {
		return jobDescriptiontext;
	}


	public void setJobDescriptiontext(WebElement jobDescriptiontext) {
		this.jobDescriptiontext = jobDescriptiontext;
	}


	public WebElement getChoseFilebutton() {
		return choseFilebutton;
	}


	public void setChoseFilebutton(WebElement choseFilebutton) {
		this.choseFilebutton = choseFilebutton;
	}


	public WebElement getJobTitle_note() {
		return jobTitle_note;
	}


	public void setJobTitle_note(WebElement jobTitle_note) {
		this.jobTitle_note = jobTitle_note;
	}


}
