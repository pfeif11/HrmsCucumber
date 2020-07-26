package com.hrms.API.utils;

import com.hrms.API.steps.practice.HardcodedExamples;

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
	public static String updateCreatedEmpBody() {
		
		String updateBody="{\r\n" + 
				"  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"Rafa\",\r\n" + 
				"  \"emp_lastname\": \"Nadal\",\r\n" + 
				"  \"emp_middle_name\": \"\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1984-05-20\",\r\n" + 
				"  \"emp_status\": \"Self-Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Consultant\"\r\n" + 
				"}";
		
		return updateBody;
		
	}

}
