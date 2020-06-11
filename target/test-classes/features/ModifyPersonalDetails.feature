Feature: Modify Personal Details

  @modify
  Scenario: 
    Given user is logged in with valid admin credentials
    And user navigates to employee list page
    Then user searches for employee with id number "11331" and click edit button
    Then user modifies employee personal details
      | Driver's License Number | License Expiry Date | SSN Number | SIN Number | Gender | Marital Status | Nationality | Date of Birth | Nick Name | Smoker | Military Service |
      | T27394                  | 2020-Sep-10         |  223749837 |   93837292 |      1 | Single         | American    | 1990-Nov-08   | Big Foe   | Smoker | NA               |
