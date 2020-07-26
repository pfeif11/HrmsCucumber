package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	@FindBy(xpath= "//div[@id='profile-pic']/h1")
	public WebElement employeeDisplayName;
	
	@FindBy(id="btnSave")
	public WebElement editButton;
	
	@FindBy(id="btnSave")
	public WebElement saveButton;
	
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driversLicenseNo;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement driversLicenseExpDate;
	
	@FindBy(id="wrapper")
	public WebElement wrapper;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement ssn;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement sin;
	
	@FindBy(id="personal_DOB")
	public WebElement dob;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement martialStatusDD;
	
	@FindBy(id="personal_txtEmpNickName")
	public WebElement nickname;
	
	@FindBy(id="personal_chkSmokeFlag")
	public WebElement smokerCheckbox;
	
	@FindBy(id="personal_txtMilitarySer")
	public WebElement militaryService;
	

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}