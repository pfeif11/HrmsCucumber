package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLoginSteps extends CommonMethods {
	

	@When("user enters valid Admin username")
	public void user_enters_valid_Admin_username() {
	sendText(login.username,ConfigsReader.getProperty("username"));
	}

	@When("user enter valid Admin password")
	public void user_enter_valid_Admin_password() {
		sendText(login.password,ConfigsReader.getProperty("password"));    
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	 click(login.loginBtn);   
	}

	@Then("user sees dashboard with Welcome Admin")
	public void user_sees_dashboard_with_Welcome_Admin() {
		String expectedWelcome="Welcome Admin";
		String actualWelcome =dashboard.welcome.getText();
		Assert.assertEquals("Login did not work",expectedWelcome,actualWelcome);
	
	  
	}

	@When("user enters valid ESS username")
	public void user_enters_valid_ESS_username() {
	 sendText(login.username,ConfigsReader.getProperty("essUsername"));   
	}

	@When("user enter valid ESS password")
	public void user_enter_valid_ESS_password() {
		sendText(login.password,ConfigsReader.getProperty("essPassword"));  
	}

	@Then("user sees dashboard with Welcome ESS")
	public void user_sees_dashboard_with_Welcome_ESS() {
		String expectedWelcome="Welcome Kamala";
		String actualWelcome =dashboard.welcome.getText();
		Assert.assertEquals("Login did not work",expectedWelcome,actualWelcome); 
		
	}

}
