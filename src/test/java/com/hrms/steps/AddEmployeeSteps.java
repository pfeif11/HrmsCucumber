package com.hrms.steps;

import org.junit.Assert;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user is logged into HRMS with Admin Credentials")
	public void user_is_logged_into_HRMS_with_Admin_Credentials() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("user navigates to Add Employee Page")
	public void user_navigates_to_Add_Employee_Page() {
		dashboard.navigateToAddEmployee();
	}

	@When("user enters {string} and {string}")
	public void user_enters_first_and_last_name(String firstName, String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		jsClick(addEmp.saveBtn);
	}

	@Then("user sees {string} is added successfully")
	public void user_sees_employee_is_added_successfully(String expectedName) {
		String actual = pdetails.employeeDisplayName.getText();
		Assert.assertEquals("Employee name does not match!", expectedName, actual);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		addEmp.employeeId.clear();
	}

	@When("user clicks on create login details checkbox")
	public void user_clicks_on_create_login_details_checkbox() {
		click(addEmp.checkboxLoginDetails);
	}

	@When("user enters {string}, {string} and confirm password")
	public void user_enters_username_password_and_confirm_password(String username, String password) {
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);
	}

	@When("user enters employee {string} and {string}")
	public void user_enters_employee_and(String firstName, String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("{string} and {string} is added successfully")
	public void and_is_added_successfully(String firstName, String lastName) {

	}

	@When("user enters employee {string} {string} {string}")
	public void user_enters_employee(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("{string} {string} {string} is added successfully")
	public void is_added_successfully(String firstName, String middleName, String lastName) {
		String actual=pdetails.employeeDisplayName.getText();
		String expected=firstName+" "+middleName+" "+lastName;
		Assert.assertEquals("names do not match!", expected, actual);
	}
	
	@When("user enters employee data from {string} excel sheet then employee is added")
	public void user_enters_employee_data_from_excel_sheet_then_employee_is_added(String sheetName) {
	    //List<Map<String,String>> excelList=ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName)
	}

}
