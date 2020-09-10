package com.hrms.API.utils;

import org.json.JSONObject;

import com.hrms.API.steps.practice.HardcodedExamples;
import com.hrms.API.steps.practice.WorkflowAllSteps;

public class PayloadConstants {
	
	
	public static String createEmployeeBody() {
		//Create employee body
		String createEmployeeBody="{\r\n" + 
				"  \"emp_firstname\": \"Roger\",\r\n" + 
				"  \"emp_lastname\": \"Federer\",\r\n" + 
				"  \"emp_middle_name\": \"F\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1981-08-08\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"Graphic Designer\"\r\n" + 
				"}";
		
		return createEmployeeBody;
	}
	//creating payload using JSONOBJECT amd returning it as a string
	public static String createEmployeePayload() {
		
		JSONObject obj=new JSONObject();
		obj.put("emp_firstname", "Roger");
		obj.put("emp_lastname", "Federer");
		obj.put("emp_middle_name", "F");
		obj.put("emp_gender", "M");
		obj.put("emp_birthday", "1981-08-08");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Graphic Designer");
		
		return obj.toString();
	}
	
	
	
	public static String updateCreatedEmpBody() {
		
		String updateBody="{\r\n" + 
				"  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"Rafa\",\r\n" + 
				"  \"emp_lastname\": \"Nadal\",\r\n" + 
				"  \"emp_middle_name\": \"J\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1984-05-20\",\r\n" + 
				"  \"emp_status\": \"Self-Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Consultant\"\r\n" + 
				"}";
		
		return updateBody;
		
	}
	
public static String updateCreatedEmplBody() {
		
		String updateBody="{\r\n" + 
				"  \"employee_id\": \""+WorkflowAllSteps.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"Rafa\",\r\n" + 
				"  \"emp_lastname\": \"Nadal\",\r\n" + 
				"  \"emp_middle_name\": \"J\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1984-05-20\",\r\n" + 
				"  \"emp_status\": \"Self-Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Consultant\"\r\n" + 
				"}";
		
		return updateBody;
		
	}

public static String partialUpdateEmplBody() {
	
	String partialUpdateBody="{\r\n" + 
			"  \"employee_id\": \""+WorkflowAllSteps.employeeID+"\",\r\n" + 
			"  \"emp_firstname\": \"Novak\",\r\n" + 
			"  \"emp_birthday\": \"1985-11-11\"\r\n" + 
			"}";
	
	return partialUpdateBody;
	
}



}
