package com.orangehrmlive.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	
	@FindBy(xpath="//a[.='Dashboard']")
	private WebElement dashBoardlink;
	
	@FindBy(xpath="//div/span[.='Invalid credentials']")
	private WebElement invalidCred;
	
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getInvalidCred() {
		return invalidCred;
	}


	public void setInvalidCred(WebElement invalidCred) {
		this.invalidCred = invalidCred;
	}


	public WebElement getDashBoardlink() {
		return dashBoardlink;
	}


	public void setDashBoardlink(WebElement dashBoardlink) {
		this.dashBoardlink = dashBoardlink;
	}

	
}
