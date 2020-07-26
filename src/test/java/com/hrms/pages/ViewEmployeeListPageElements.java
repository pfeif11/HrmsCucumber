package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy (id="resultTable")
	public WebElement employeesTable;
	
	@FindBy (xpath= "//table[@id='resultTable']//tbody/tr/td[3]")
	public List<WebElement> tableFirstName;
	
	
	/**
	 * This method will check in employees table is displayed
	 * @return
	 */
	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}
	
	public List<Map<String,String>> getFirstNameFromTable() {
		List<Map<String,String>> uiName = new ArrayList<>();
		for (WebElement row : tableFirstName) {
			Map<String,String> storeUiNames= new LinkedHashMap<>();
			String tableName = row.getText();
			storeUiNames.put("emp_firstname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}
	
	
	public ViewEmployeeListPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
