Feature: Employee Search

  Scenario: Search employee by id
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee id
    And user clicks on search button
    Then user sees employee information is displayed
    
   Scenario: Search employee by name
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee name and last name
    And user clicks on search button
    Then user sees employee information is displayed