package com.hrms.API.utils;

public class APIConstants {
	
	//CONSTANT ENDPOINTS
	
	public static final String GENERATE_TOKEN_ENDPOINT="/generateToken.php";
	
	public static final String CREATE_EMPLOYEE_ENDPOINT="/createEmployee.php";
	
	public static final String GET_ONE_EMPLOYEE_ENDPOINT="/getOneEmployee.php";
	
	public static final String GET_ALL_EMPLOYEES_ENDPOINT="/getAllEmployees.php";
	
	public static final String UPDATE_EMPLOYEE_ENDPOINT="/updateEmployee.php";
	
	public static final String PARTIAL_UPDATE_EMPLOYEE_ENDPOINT="/updatePartialEmplyeesDetails.php";
	
	public static final String DELETE_EMPLOYEE_ENDPOINT="/deleteEmployee.php";
	
	public static final String GET_JOB_TITLES_ENDPOINT="/jobTitle.php";
	
	public static final String GET_EMPLOYEE_STATUS_ENDPOINT="/employeeStatus.php";
	
	public static final String CREATE_EMPLOYEE_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createEmployee.json";

	public static final String GENERATE_TOKEN_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/generateToken.json";

	public static final String UPDATE_EMPLOYEE_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/updateEmployee.json";

	public static final String STORE_JSON = System.getProperty("user.dir") + "/src/test/resources/JSONFiles/store.json";

	public static final String TOKEN_TXT = System.getProperty("user.dir") + "/src/test/resources/JSONFiles/token.txt";

}
