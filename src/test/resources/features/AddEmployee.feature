@sprint210
Feature: AddEmployee

  Background: 
    Given user is logged into HRMS with Admin Credentials
    And user navigates to Add Employee Page

  #Scenario: Admin adds new Employee
    #When user enters "Roger" and "Federer"
    #And user clicks save button
    #Then user sees "Roger Federer" is added successfully
#
  #Scenario: Admin adds new Employee without employee id
    #When user enters "Rafa" and "Nadal"
    #And user deletes employee id
    #And user clicks save button
    #Then user sees "Rafa Nadal" is added successfully
#

  Scenario: Admin adds new Employee and creates login details
    When user enters "Novak" and "Djokovic"
    And user clicks on create login details checkbox
    And user enters "ndjokovic12", "Syntax!!11" and confirm password
    And user clicks save button
    Then user sees "Novak Djokovic" is added successfully

  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>" "<MiddleName>" "<LastName>"
    And user clicks save button
    Then "<FirstName>" "<MiddleName>" "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName  |
      | Francis   | T          | Tiafoe    |
      | Stepanos  | T          | Tsitsipas |
      #| Nick      | K          | Kyrgios   |
      #| A         | M          | Murray    |
      
      @excel
      Scenario: Adding multiple employees from excel
      When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added
