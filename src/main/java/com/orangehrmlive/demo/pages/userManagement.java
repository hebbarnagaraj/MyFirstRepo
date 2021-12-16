package com.orangehrmlive.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userManagement {
	
	
	@FindBy(xpath="//div[@id='mainMenu']//a[.='Admin']")
	private WebElement Admintag;
	
	@FindBy(xpath="//div[@id='mainMenu']//a[.='User Management']")
	private WebElement userManagementtag;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement addUserbtn;
	
	@FindBy(xpath="//select[@id='systemUser_userType']")
	private WebElement userRoleSelect;
	
	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']")
	private WebElement employeeNameinput;
	
	@FindBy(xpath="//input[@id='systemUser_userName']")
	private WebElement userNameinput;
	
	@FindBy(xpath="//select[@id='systemUser_status']")
	private WebElement statusSelect;
	
	@FindBy(xpath="//input[@id='systemUser_password']")
	private WebElement passWordinput;
	
	@FindBy(xpath="//input[@id='systemUser_confirmPassword']")
	private WebElement confirmPasswordinput;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement saveUserbtn;
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	private WebElement userNametag;
	
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//table/tbody//td[2]")
	private WebElement tableUserNametag;
	
	@FindBy(xpath="//table//td[1]")
	private WebElement selectTabelusercheckbox;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	private WebElement deleteUserbtn;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	private WebElement confirmDeletebtn;
	
	@FindBy(xpath="//div/span[@id='systemUser_password_strength_meter']")
	private WebElement strengthMeter;
	
	
	
	public userManagement(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getStrengthMeter() {
		return strengthMeter;
	}



	public void setStrengthMeter(WebElement strengthMeter) {
		this.strengthMeter = strengthMeter;
	}



	public WebElement getAddUserbtn() {
		return addUserbtn;
	}



	public void setAddUserbtn(WebElement addUserbtn) {
		this.addUserbtn = addUserbtn;
	}



	public WebElement getDeleteUserbtn() {
		return deleteUserbtn;
	}



	public void setDeleteUserbtn(WebElement deleteUserbtn) {
		this.deleteUserbtn = deleteUserbtn;
	}



	public WebElement getConfirmDeletebtn() {
		return confirmDeletebtn;
	}



	public void setConfirmDeletebtn(WebElement confirmDeletebtn) {
		this.confirmDeletebtn = confirmDeletebtn;
	}



	public WebElement getSelectTabelusercheckbox() {
		return selectTabelusercheckbox;
	}



	public void setSelectTabelusercheckbox(WebElement selectTabelusercheckbox) {
		this.selectTabelusercheckbox = selectTabelusercheckbox;
	}



	public WebElement getAdmintag() {
		return Admintag;
	}



	public void setAdmintag(WebElement admintag) {
		Admintag = admintag;
	}



	public WebElement getUserManagementtag() {
		return userManagementtag;
	}



	public void setUserManagementtag(WebElement userManagementtag) {
		this.userManagementtag = userManagementtag;
	}



	public WebElement getUserRoleSelect() {
		return userRoleSelect;
	}



	public void setUserRoleSelect(WebElement userRoleSelect) {
		this.userRoleSelect = userRoleSelect;
	}



	public WebElement getEmployeeNameinput() {
		return employeeNameinput;
	}



	public void setEmployeeNameinput(WebElement employeeNameinput) {
		this.employeeNameinput = employeeNameinput;
	}



	public WebElement getUserNameinput() {
		return userNameinput;
	}



	public void setUserNameinput(WebElement userNameinput) {
		this.userNameinput = userNameinput;
	}



	public WebElement getStatusSelect() {
		return statusSelect;
	}



	public void setStatusSelect(WebElement statusSelect) {
		this.statusSelect = statusSelect;
	}



	public WebElement getPassWordinput() {
		return passWordinput;
	}



	public void setPassWordinput(WebElement passWordinput) {
		this.passWordinput = passWordinput;
	}



	public WebElement getConfirmPasswordinput() {
		return confirmPasswordinput;
	}



	public void setConfirmPasswordinput(WebElement confirmPasswordinput) {
		this.confirmPasswordinput = confirmPasswordinput;
	}



	public WebElement getSaveUserbtn() {
		return saveUserbtn;
	}



	public void setSaveUserbtn(WebElement saveUserbtn) {
		this.saveUserbtn = saveUserbtn;
	}



	public WebElement getUserNametag() {
		return userNametag;
	}



	public void setUserNametag(WebElement userNametag) {
		this.userNametag = userNametag;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}



	public WebElement getTableUserNametag() {
		return tableUserNametag;
	}



	public void setTableUserNametag(WebElement tableUserNametag) {
		this.tableUserNametag = tableUserNametag;
	}
	
	

	
	

}
