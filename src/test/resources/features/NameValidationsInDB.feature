Feature: Name validations against DB

Scenario: First Name validation against DB
Given user is logged into HRMS with Admin Credentials
And user navigates to employee list page
When user enters valid employee id "10079"
And user clicks on search button
Then verify table is displayed
And get first name from table
When get first name from db
Then validate firstname from ui against db
