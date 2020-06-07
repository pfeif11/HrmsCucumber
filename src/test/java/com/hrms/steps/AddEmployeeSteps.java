package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

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

	@When("user enters first and last name")
	public void user_enters_first_and_last_name() {
	    sendText(addEmp.firstName, "Roger");
	    sendText(addEmp.lastName,"Federer");
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    click(addEmp.saveBtn);
	}

	@Then("user sees employee is added successfully")
	public void user_sees_employee_is_added_successfully() {
	   String expected="Roger Federer";
	   String actual=pdetails.employeeDisplayName.getText();
	   Assert.assertEquals("Employee name does not match!",expected, actual);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	   addEmp.employeeId.clear();
	}

	@When("user clicks on create login details checkbox")
	public void user_clicks_on_create_login_details_checkbox() {
	  click(addEmp.checkboxLoginDetails);
	}

	@When("user enters username, password and confirm password")
	public void user_enters_username_password_and_confirm_password() {
	    sendText(addEmp.username, "rogerfederer1");
	    sendText(addEmp.password, "Syntax!!11");
	    sendText(addEmp.confirmPassword, "Syntax!!11");
	}


}
