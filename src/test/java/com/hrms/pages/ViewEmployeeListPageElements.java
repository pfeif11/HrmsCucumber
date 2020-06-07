package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeeListPageElements {
	
	@FindBy (id="empsearch_employee_name_empName")
	public WebElement empName;
	
	@FindBy (id="empsearch_id")
	public WebElement empID;
	
	@FindBy (id="searchBtn")
	public WebElement searchButton;
	
	@FindBy (xpath="//table[@id='resultTable']/tbody/tr/td/a")
	public WebElement afterSearchEmpId;
	
	@FindBy (xpath="(//table[@id='resultTable']//td/a)[2]")
	public WebElement empSrcFirstName;
	
	public ViewEmployeeListPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
