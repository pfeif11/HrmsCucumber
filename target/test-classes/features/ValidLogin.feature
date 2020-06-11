Feature: Valid Login
  #previous written test
  #@smoke
  #Scenario: Login with valid credentials
    #When user enters valid "<Username>"
    #And user enter valid "<Password>"
    #And user clicks login button
    #Then user sees dashboard with Welcome "<FirstName>"


  Scenario Outline: 
    When user enters valid "<Username>"
    And user enter valid "<Password>"
    And user clicks login button
    Then user sees dashboard with Welcome "<FirstName>"

    Examples: 
      | Username | Password    | FirstName |
      | Admin    | Hum@nhrm123 | Admin     |
      | abd77    | Syntax123!  | Abdullah  |
