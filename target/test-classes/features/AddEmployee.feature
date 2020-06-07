Feature: AddEmployee

Background:
Given user is logged into HRMS with Admin Credentials
And user navigates to Add Employee Page


  Scenario: Admin adds new Employee
    When user enters first and last name
    And user clicks save button
    Then user sees employee is added successfully

  Scenario: Admin adds new Employee without employee id
    When user enters first and last name
    And user deletes employee id
    And user clicks save button
    Then user sees employee is added successfully

  Scenario: Admin adds new Employee and creates login details
    When user enters first and last name
    And user clicks on create login details checkbox
    And user enters username, password and confirm password
    And user clicks save button
    Then user sees employee is added successfully
