Feature: Modify Personal Details

  @modify
  Scenario: 
    Given user is logged in with valid admin credentials
    And user navigates to employee list page
    When user searches for employee with id number "11331" and click edit button
    Then user modifies employee personal details
      | Driver's License Number | License Expiry Date | SSN Number | SIN Number | Gender | Marital Status | Nationality | Date of Birth | Nick Name | Military Service |
      | T27394                  | 2020-Aug-01         |  223749837 |   93837292 |      1 | Single         | American    | 2020-Oct-09   | Big Foe   | NA               |
	Then user save modifications and takes "modifyDetails"