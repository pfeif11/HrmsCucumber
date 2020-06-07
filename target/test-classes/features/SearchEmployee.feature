@searchEmployee @sprint13
Feature: Employee Search

  Background: 
    Given user is logged in with valid admin credentials
    Given user navigates to employee list page

  @smoke
  Scenario: Search employee by id
    When user enters valid employee id
    And user clicks on search button
    Then user sees employee information is displayed

  Scenario: Search employee by name
    When user enters valid employee name and last name
    And user clicks on search button
    Then user sees employee name is displayed
