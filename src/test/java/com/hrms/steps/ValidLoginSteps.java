package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLoginSteps extends CommonMethods {
	

	
	@When("user enters valid {string}")
	public void user_enters_valid_username(String username) {
	sendText(login.username,username);
	}

	@When("user enter valid {string}")
	public void user_enter_valid_password(String password) {
		sendText(login.password,password);    
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	 click(login.loginBtn);   
	}

	@Then("user sees dashboard with Welcome {string}")
	public void user_sees_dashboard_with_Welcome_first_name(String firstName) {
		String expectedWelcome="Welcome "+firstName;
		String actualWelcome =dashboard.welcome.getText();
		Assert.assertEquals("Login did not work",expectedWelcome,actualWelcome);
		
	}

}
