package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {



	@When("user enter valid username")
	public void user_enter_valid_username() {
	    sendText(login.username, ConfigsReader.getProperty("username"));
	}
	

	@When("user enter invalid password and clicks login")
	public void user_enter_invalid_password_and_clicks_login() {
	    sendText(login.password,"asdasdsd");
	    click(login.loginBtn);
	    wait(2);
	}

	@Then("user sees invalid credentials error message")
	public void user_sees_invalid_credentials_error_message() {
	    String actualErrorMsg="Invalid credentials";
	    String expectedErrorMsg=login.errorMsg.getText();
	    Assert.assertEquals("Error message does not match", actualErrorMsg, expectedErrorMsg);
	    tearDown();
	}

	@When("user enters empty password  and clicks login")
	public void user_enters_empty_password_and_clicks_login() {
	    click(login.loginBtn);
	    wait(2);
	}

	@Then("user sees Password can not be empty error message")
	public void user_sees_Password_can_not_be_empty_error_message() {
		String actualErrorMsg="Password cannot be empty";
	    String expectedErrorMsg=login.errorMsg.getText();
	    Assert.assertEquals("Error message does not match", actualErrorMsg, expectedErrorMsg);
	    
	}

	@When("user enter empty username")
	public void user_enter_empty_username() {
	    login.username.clear();
	}

	@When("user enters valid password  and clicks login")
	public void user_enters_valid_password_and_clicks_login() {
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		wait(2);
	}

	@Then("user sees Username can not be empty error message")
	public void user_sees_Username_can_not_be_empty_error_message() {
		String actualErrorMsg="Username cannot be empty";
	    String expectedErrorMsg=login.errorMsg.getText();
	    Assert.assertEquals("Error message does not match", actualErrorMsg, expectedErrorMsg);
	    
	}
}
