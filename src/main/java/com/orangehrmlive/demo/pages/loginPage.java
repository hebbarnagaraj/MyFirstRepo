package com.orangehrmlive.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage{
	
	
	@FindBy(xpath="//div/*[@id='txtUsername']")
	private WebElement userName;


	@FindBy(xpath="//div/*[@id='txtPassword']")
	private WebElement passWOrd;
	

	@FindBy(xpath="//div/*[@id='btnLogin']")
	private WebElement loginBtn;
	
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPassWOrd() {
		return passWOrd;
	}

	public void setPassWOrd(WebElement passWOrd) {
		this.passWOrd = passWOrd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	
}
