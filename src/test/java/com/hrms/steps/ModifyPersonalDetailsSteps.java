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
		wait(2);
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
		   wait(2);
		   click(pdetails.smokerCheckbox);
		  sendText(pdetails.driversLicenseExpDate,map.get("License Expiry Date"));
		  click(pdetails.wrapper);
		   sendText(pdetails.ssn, map.get("SSN Number"));
		   sendText(pdetails.sin, map.get("SIN Number"));
		   clickRadioOrCheckbox(pdetails.genderRadioGroup, map.get("Gender"));
		   selectDdValue(pdetails.martialStatusDD, map.get("Marital Status"));
		   selectDdValue(pdetails.nationalityDD, map.get("Nationality"));
		   wait(2);
		   sendText(pdetails.dob,map.get("Date of Birth"));
		   click(pdetails.wrapper);
		   sendText(pdetails.nickname, map.get("Nick Name"));
		   click(pdetails.smokerCheckbox);
		   sendText(pdetails.militaryService, map.get("Military Service"));
		   click(pdetails.saveButton);
		   wait(4);
		   takeScreenshot("modifydetails.png");
		   
	   }
	   


	}
	@Then("user save modifications and takes {string}")
	public void user_save_modifications_and_takes(String screenshot) {
		takeScreenshot(screenshot);
	}
	
}
