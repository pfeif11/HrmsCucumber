Feature: Login

  @smoke
  Scenario: Login with valid username and invalid password
    When user enter valid username
    And user enter invalid password and clicks login
    Then user sees invalid credentials error message

  @regression
  Scenario: Login with valid username and without password
    When user enter valid username
    And user enters empty password  and clicks login
    Then user sees Password can not be empty error message

  @regression
  Scenario: Login without username and valid password
    When user enter empty username
    And user enters valid password  and clicks login
    Then user sees Username can not be empty error message
