package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ModifyPersonalDetailsSteps extends CommonMethods {

	@Then("user searches for employee with id number {string} and click edit button")
	public void user_searches_for_employee_with_id_number_and_click_edit_button(String id) {
	   
		sendText(viewEmp.empID, id );
	    click(viewEmp.searchButton);
	    Assert.assertEquals("Ids do not match",id ,viewEmp.afterSearchEmpId.getText());
	    click(viewEmp.afterSearchEmpId);
	    click(pdetails.editButton);
	}

	@Then("user modifies employee personal details")
	public void user_modifies_employee_personal_details(DataTable dataTable) {
	   List<Map<String, String>> maps = dataTable.asMaps();
	   for(Map<String,String> map:maps) {
		   sendText(pdetails.driversLicenseNo, map.get("Driver's License Number"));
		  // sendText(pdetails.driversLicenseExpDate,"License Expiry Date");
		   sendText(pdetails.ssn, map.get("SSN Number"));
		   sendText(pdetails.sin, map.get("SIN Number"));
		   clickRadioOrCheckbox(pdetails.genderRadioGroup, "Gender");
		   selectDdValue(pdetails.martialStatusDD, "Marital Status");
		   selectDdValue(pdetails.nationalityDD, "Nationality");
		   //sendText(pdetails.dob,"Date of Birth");
		   sendText(pdetails.nickname, map.get("Nick Name"));
		   click(pdetails.smokerCheckbox);
		   sendText(pdetails.militaryService, map.get("Military Service"));
		   click(pdetails.saveButton);
		   takeScreenshot("modifydetails.png");
		   
		   
		   
		   
	   }
	}
}
