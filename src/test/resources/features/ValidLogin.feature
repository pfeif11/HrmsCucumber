Feature: Valid Login

	@smoke
  Scenario: Login with valid Admin credentials
    
    When user enters valid Admin username
    And user enter valid Admin password
    And user clicks login button
    Then user sees dashboard with Welcome Admin

  @smoke
  Scenario: Login with valid ESS credentials
    When user enters valid ESS username
    And user enter valid ESS password
    And user clicks login button
    Then user sees dashboard with Welcome ESS

