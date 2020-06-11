package com.hrms.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {
	
	
	@Then("user should see dashboard menu is displayed")
	public void user_should_see_dashboard_menu_is_displayed(DataTable table) {
		List<String> expectedMenu=table.asList();
		List<String> actualMenu=new ArrayList<>();
		
		for(WebElement el:dashboard.dashMenu) {
			actualMenu.add(el.getText());
		}
		System.out.println(expectedMenu);
		System.out.println(actualMenu);
		Assert.assertEquals("Menus do not match", expectedMenu, actualMenu);
	}

}
