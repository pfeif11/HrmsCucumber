package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//rest assured packages
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

//importing jUnit packages
import org.junit.Assert;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runners.MethodSorters;
/*
 * we may use below, please comment out for now
 */
//import org.apache.hc.core5.http.ContentType;
//This FixMethodOrder will execute @Test annotation in ascending alphabetical order

import com.hrms.API.utils.PayloadConstants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {
	/*
	 * Rest Assured (BDD) given - prepare your request when - you are making the
	 * call to the endpoint then - validating
	 * 
	 */
	// we made base URI and token global, we are going to write other scripts that
	// are going to use it
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	public static String employeeID;
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTY2NDA2NzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NjY4Mzg3MSwidXNlcklkIjoiNDg0In0.YFb_U_SinlDkaTrvDQPfhbXcYBn7ZbeXuBr180rEw-Q";

	public void sampleTestNotes() {
		// baseURL for all calls
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		// JWT for all calls - expire every 12 hours
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwOTQ4NjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEzODA2MSwidXNlcklkIjoiNDg0In0.SK-mUAx7m_IUXA9VbKfeDIlpjGfaiWmVLACaZberPVQ";

		// Preparing getOneEmployee.php request
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16492A").log().all(); // .log().all() shows
																									// more info what's
																									// being sent with
																									// the request

		// Storing response
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		// when you have declared a base URI, during runtime it is concatenating base
		// URI+endpoint

		// 2 ways to print response
		// getOneEmployeeResponse.body().asString();
		// Then sysout

		// This will convert to string and print
		getOneEmployeeResponse.prettyPrint();

		// Verifying response status code is 200
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {
		// Preparing request for /createEmployee.php
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"Roger\",\r\n" + "  \"emp_lastname\": \"Federer\",\r\n"
						+ "  \"emp_middle_name\": \"\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"1981-08-08\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Graphic Designer\"\r\n" + "}")
				.log().all();
		// Storing response into reference variable
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		// Printing response using prettyPrint() method
		System.out.println("-----------CREATE EMPLOYEE---------");
		createEmployeeResponse.prettyPrint();
		// jsonPath to view response body which lets us get the employee id
		//
		// storing employee_id as a global variable so that we may use it with our other
		// calls
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		// printing out employeeID
		System.out.println(employeeID);

		// verifying status code is 201
		createEmployeeResponse.then().assertThat().statusCode(201);

		// Verifying message using equalTo() method - manually import static package
		// import static org.hamcrest.Matchers.*;
		// Verifying entry created text in body
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		// Verifying created first name
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Roger"));
		// verifying server
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		// verifying content type
		createEmployeeResponse.then().header("Content-Type", "application/json");
		// verifying content length using then().header
		createEmployeeResponse.then().header("Content-Length", "392");
		// verifying connection using assert That
		createEmployeeResponse.then().assertThat().header("Connection", "Keep-Alive");

	}

	@Test
	public void bGETcreatedEmployee() {

		// Preparing request for /getOneEmployee.php
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		// making call to retrieve created employee
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		// storing response as String
		System.out.println("-----------GET CREATED EMPLOYEE---------");
		String response = getCreatedEmployeeResponse.prettyPrint();

		// viewing the json response and getting the employee id 1st way
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		// verifying employee id matches the one we received from the previous response
		boolean verifyingEmployeeIDsMatch = empID.equalsIgnoreCase(employeeID);
		System.out.println("Employee IDs match:" + verifyingEmployeeIDsMatch);
		// Asserting employee id match
		Assert.assertTrue(verifyingEmployeeIDsMatch);

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		// retrieve any values from json, expecting a string argument
		// creating an object of json path
		// 2nd way
		JsonPath js = new JsonPath(response);
		
		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		System.out.println("Middle name is " + middleName);
		String lastName = js.getString("employee[0].emp_lastname");
		String emp_bday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID);
		System.out.println(firstName);
		System.out.println(middleName);

		// content equals, we want to get an each match
		Assert.assertTrue(emplID.contentEquals(employeeID));

		Assert.assertTrue(firstName.contentEquals("Roger"));
		Assert.assertEquals(middleName, null);
		// Assert.assertTrue(middleName.contentEquals("null"));
		Assert.assertTrue(lastName.contentEquals("Federer"));
		Assert.assertTrue(emp_bday.contentEquals("1981-08-08"));
		Assert.assertTrue(gender.contentEquals("Male"));
		Assert.assertTrue(jobTitle.contentEquals("Graphic Designer"));
		// verifying expected employee status matched actual employee status
		Assert.assertTrue(empStatus.contentEquals("Employee"));

	}

	@Test
	public void cGETallEmployees() {
		// Preparing get All Employees Request
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);
		// Storing response into getAllEmployeesResponse
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		// Printing all employees
		// getAllEmployeesResponse.prettyPrint();
		String allEmployees = getAllEmployeesResponse.body().asString();

		JsonPath js = new JsonPath(allEmployees);

		// retrieving size of Employee list
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println("size:" + sizeOfList);

		// Printing all employee ids
//		for (int i = 0; i < sizeOfList; i++) {
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//			// System.out.println(allEmployeeIDs);
//			String empName=js.getString("Employees["+i+"].emp_firstname");
//			if(allEmployeeIDs.equals(employeeID)) {
//				System.out.println(allEmployeeIDs+":"+empName);
//				break;
//			}
//		}

	}

	@Test
	public void dPUTupdateCreatedEmployee() {
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmpBody());

		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		System.out.println("-----------PUT UPDATED CREATED EMPLOYEE--------");
		String response = updateCreatedEmployeeResponse.prettyPrint();
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		String empID= updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		Assert.assertTrue(empID.contentEquals(employeeID));

	}

	@Test
	public void eGETupdatedEmployee() {
		
		RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id",employeeID);
		
		Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		System.out.println("-------------GET UPDATED EMPLOYEE---------");
		getUpdatedEmployeeResponse.prettyPrint();
		
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("Rafa"));
	}

	@Test
	public void fPATCHpartiallyUpdatingEmployee() {
		
		RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).body("{\r\n" + 
				"  \"employee_id\": \""+employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"Novak\",\r\n" + 
				"  \"emp_birthday\": \"1985-11-11\"\r\n" + 
				"}");
		Response partiallyUpdatingEmployeeResponse=partiallyUpdatingEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
		
		System.out.println("------PATCH PARTIALLY UPDATING EMPLOYEE");
		partiallyUpdatingEmployeeResponse.prettyPrint();
		partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);
		partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	}

	@Test
	public void gGETpartiallyUpdatedEmployee() {
	
		RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id", employeeID);
		Response partiallyUpdatingEmployeeResponse=partiallyUpdatingEmployeeRequest.given().get("/getOneEmployee.php");
		System.out.println("-----------GETTING PARTIALLY UPDATED EMPLOYEE---------");
		partiallyUpdatingEmployeeResponse.prettyPrint();
	}

	@Test
	public void hDELETEdeletingEmployee() {
		RequestSpecification deletingEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id", employeeID);
		Response deletingEmployeeResponse=deletingEmployeeRequest.when().delete("/deleteEmployee.php");
		System.out.println("----------DELETING EMPLOYEE---------");
		deletingEmployeeResponse.prettyPrint();
		deletingEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
		deletingEmployeeResponse.then().assertThat().statusCode(201);
		System.out.println(deletingEmployeeResponse.getStatusCode());
		
	}
	
	@Test
	public void iGETemployeeStatus() {
		RequestSpecification employeeStatusRequest=given().header("Content-Type","application/json").header("Authorization",token);
		Response employeeStatusResponse=employeeStatusRequest.when().get("/employeeStatus.php");
		System.out.println("-----------GETTING EMPLOYEE STATUSES---------");
		employeeStatusResponse.prettyPrint();
		
	}
	
	@Test
	public void jGETjobTitles () {
		RequestSpecification jobTitlesRequest=given().header("Content-Type","application/json").header("Authorization",token);
		Response jobTitlesResponse=jobTitlesRequest.when().get("/jobTitle.php");
		System.out.println("-----------GETTING JOB TITLES---------");
		//jobTitlesResponse.prettyPrint();
		JSONObject jsonObj = new JSONObject(jobTitlesResponse);
		JSONArray arrJson = jsonObj.getJSONArray("Job Title List");
		String[] arr = new String[arrJson.length()];
		for (int i = 0; i < arrJson.length(); i++) {
			arr[i] = arrJson.getString(i);
			System.out.println(arr[i]);
		}
		
		} 
	}

