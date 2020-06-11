package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.google.common.collect.Maps;
import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;




public class InvalidLoginSteps extends CommonMethods {
	
	@When("user enters invalid username and password, click login and see error message")
	public void user_enters_invalid_username_and_password_click_login_and_see_error_message(DataTable dataTable) {
	   List<Map<String,String>> listOfMaps=dataTable.asMaps();
	   for(Map<String,String>map:listOfMaps) {
		   sendText(login.username, map.get("Username"));
		   sendText(login.password, map.get("Password"));
		   click(login.loginBtn);
		   String actual=login.errorMsg.getText();
		   String expected=map.get("ErrorMessage");
		   Assert.assertEquals("Error Message does not match", expected, actual);
	   }
	    
	}	

	
}
