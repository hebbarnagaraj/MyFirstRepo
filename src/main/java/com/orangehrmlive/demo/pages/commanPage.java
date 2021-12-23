package com.orangehrmlive.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class commanPage {

	
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement addUserbtn;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement saveUserbtn;
	
	@FindBy(xpath="//div[@id='mainMenu']//a[.='Admin']")
	private WebElement Admintag;
	
	public commanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAdmintag() {
		return Admintag;
	}


	public void setAdmintag(WebElement admintag) {
		Admintag = admintag;
	}


	public WebElement getAddUserbtn() {
		return addUserbtn;
	}


	public WebElement getSaveUserbtn() {
		return saveUserbtn;
	}


	public void setSaveUserbtn(WebElement saveUserbtn) {
		this.saveUserbtn = saveUserbtn;
	}


	public void setAddUserbtn(WebElement addUserbtn) {
		this.addUserbtn = addUserbtn;
	}
	
	
}
