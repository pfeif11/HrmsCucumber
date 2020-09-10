package com.hrms.utils;
import static io.restassured.RestAssured.given;

import com.hrms.API.steps.practice.TokenGenerationSteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class API_CommonMethods {
/**
 * @author Bayramgul
 * In this method  headers will be passed which are used with given()in requests of postCreateEmployee,
 * GetOneEMployeeAPISteps,GetAllEmmployee,GetAllJobTitles,PutUpdateEmployee
 */
	public RequestSpecification headersInRequest() {
		RequestSpecification request =given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token);
	return request;
	}
	
	/**
	 * Declaring Private variable to initialize inside methods
	 */
	private Response responseVariable = null;
	private RequestSpecification requestHeaders = null;

	// this is Base URL not Base URI
	static String BaseUrl = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	
	public RequestSpecification prepareRequest() {
		RequestSpecification request =given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token);
	return request;
	}
	public RequestSpecification prepareRequest(String body) {
		RequestSpecification request =given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).body(body);
	return request;
	}
	
	public RequestSpecification prepareRequest(String queryParam,String queryParamValue) {
		RequestSpecification request =given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token).queryParam(queryParam, queryParamValue);
	return request;
	}

}

	