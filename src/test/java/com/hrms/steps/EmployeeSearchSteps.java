package com.hrms.steps;



import org.junit.Assert;


import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeeSearchSteps extends CommonMethods {
	
	@Given("user is navigated to HRMS")
	public void user_is_navigated_to_HRMS() {
	   setUp();
	}

	@Given("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
	 login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	 click(login.loginBtn);
	}

	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
	jsClick(dashboard.PIM);
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
	sendText(viewEmp.empID, "10104");   
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	jsClick(viewEmp.searchButton);
	   
	}

	@Then("user sees employee information is displayed")
	public void user_sees_employee_information_is_displayed() {
	String actualId="10140";
	String expectedId=viewEmp.afterSearchEmpId.getText();
	Assert.assertEquals(actualId, expectedId);
	tearDown();
	}

	@When("user enters valid employee name and last name")
	public void user_enters_valid_employee_name_and_last_name() {
	sendText(viewEmp.empName,"Kobe Bryant");
	   
	}

}
