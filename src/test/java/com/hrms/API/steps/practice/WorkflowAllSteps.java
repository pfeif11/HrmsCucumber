package com.hrms.API.steps.practice;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import static io.restassured.RestAssured.*;

import com.hrms.API.utils.APIConstants;
import com.hrms.API.utils.PayloadConstants;
import com.hrms.utils.API_CommonMethods;

public class WorkflowAllSteps extends API_CommonMethods{

	
	RequestSpecification request;
	Response response;
	public static String employeeID;

	/**
	 * CREATE EMPLOYEE
	 */
	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
		request=prepareRequest(PayloadConstants.createEmployeeBody());
		//request=prepareRequest(PayloadConstants.createEmployeePayload());
		//request=headersInRequest().body(PayloadConstants.createEmployeePayload());
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationSteps.token)
//				.body(PayloadConstants.createEmployeePayload());
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_ENDPOINT);
		

	}

	@Then("the status code is {int}")
	public void the_status_code_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
		System.out.println(statusCode);
	}

	@Then("the employee is created and response contains key {string} and value {string}")
	public void the_employee_is_created_and_response_contains_key_and_value(String key, String value) {
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
		employeeID = response.body().jsonPath().getString(empID);
		System.out.println(employeeID);
	}
	
	/**
	 * GET CREATED EMPLOYEE
	 */
	
	@Given("a request is prepared  to retrieve the employee from previous call")
	public void a_request_is_prepared_to_retrieve_the_employee_from_previous_call() {
		request=prepareRequest("employee_id",employeeID);
		//request=headersInRequest().queryParams("employee_id", employeeID);
		
		//request=given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).queryParam("employee_id", employeeID);
	}
	
	@When("a GET call is made to retrieve the employee")
	public void a_GET_call_is_made_to_retrieve_the_employee() {
		response=request.when().get(APIConstants.GET_ONE_EMPLOYEE_ENDPOINT);
	}

	@Then("the retrieved employee ID at {string} matches the globally stored employee ID")
	public void the_retrieved_employee_ID_at_matches_the_globally_stored_employee_ID(String value) {
		String empID=response.body().jsonPath().getString(value);
		   Assert.assertTrue(empID.contentEquals(employeeID));
	}
	
	
	
	@Then("the retrieved data at {string} matches the data used to create an employee with employee ID {string}")
	public void the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(String employeeObject, String responseEmployeeID, DataTable dataTable) {
		List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
	     List<Map<String, String>> actualData= response.jsonPath().get(employeeObject);
	     
	     int index=0;
	     
	     for (Map<String, String> map : expectedData) {
			Set<String> keys=map.keySet();
			for(String key:keys) {
				String expectedValue=map.get(key);
				String actualValue=actualData.get(index).get(key);
				Assert.assertEquals(expectedValue, actualValue);
			}
			index++;
		}
	     String empID=response.body().jsonPath().getString(responseEmployeeID);
		   Assert.assertTrue(empID.contentEquals(employeeID));
	}
	/**
	 * UPDATE CREATED EMPLOYEE
	 */
	@Given("a request is prepared to Update the employee")
	public void a_request_is_prepared_to_Update_the_employee() {
		request=prepareRequest(PayloadConstants.updateCreatedEmplBody());
		//request=headersInRequest().body(PayloadConstants.updateCreatedEmplBody());
		//request=given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).body(PayloadConstants.updateCreatedEmplBody());
	}

	@When("a PUT call is made to update the employee")
	public void a_PUT_call_is_made_to_update_the_employee() {
	    response=request.when().put(APIConstants.UPDATE_EMPLOYEE_ENDPOINT);
	}

	@Then("the employee is updated and response contains key {string} and value {string}")
	public void the_employee_is_updated_and_response_contains_key_and_value(String key, String value) {
	    response.then().assertThat().body(key, equalTo(value));
	}
	
	/**
	 * PARTIALLY UPDATE EMPLOYEE
	 */

	@Given("a request is prepared to partially update the employee")
	public void a_request_is_prepared_to_partially_update_the_employee() {
		request=prepareRequest(PayloadConstants.partialUpdateEmplBody());
		//request = headersInRequest().body(PayloadConstants.partialUpdateEmplBody()); 
	}

	@When("a PATCH call is made to partially update the employee")
	public void a_PATCH_call_is_made_to_partially_update_the_employee() {
	   response=request.when().patch(APIConstants.PARTIAL_UPDATE_EMPLOYEE_ENDPOINT);
	}

	/**
	 * DELETING EMPLOYEE
	 */
	
	@Given("a request is prepared  to delete an employee")
	public void a_request_is_prepared_to_delete_an_employee() {
		request=prepareRequest("employee_id",employeeID);
		//request = headersInRequest().queryParam("employee_id", employeeID);
		//request=given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).queryParam("employee_id", employeeID);
	}

	@When("a DELETE call is made to delete the employee")
	public void a_DELETE_call_is_made_to_delete_the_employee() {
	    response=request.when().delete(APIConstants.DELETE_EMPLOYEE_ENDPOINT);
	}
	
	@Then("verifying the employee is deleted with get call with response containing key {string} and value {string}")
	public void verifying_the_employee_is_deleted_with_get_call_with_response_containing_key_and_value(String key, String value) {
		request=prepareRequest("employee_id",employeeID);
		response=request.when().get(APIConstants.GET_ONE_EMPLOYEE_ENDPOINT);
		response.then().assertThat().body(key, equalTo(value));
	}

}
