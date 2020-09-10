@US31
Feature: Syntax HRMS Webservice workflow verification
  Description: This feature tests and verifies Syntax HRMS web Services which includes creating an employee, 
  updating the created employee, partially updating th employee, and deleting the employeee

  
  Scenario: Creating an employee
    Given a JWT is generated
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code is 201
    And the employee is created and response contains key "Message" and value "Entry Created"
    And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

 
  Scenario: Retrieving created employee
    Given a request is prepared  to retrieve the employee from previous call
    When a GET call is made to retrieve the employee
    Then the status code is 200
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" matches data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title    | emp_status |
      | Roger         | F               | Federer      | 1981-08-08   | Male       | Graphic Designer | Employee   |

  
  Scenario: Updating the created employee
    Given a request is prepared to Update the employee
    When a PUT call is made to update the employee
    Then the status code is 201
    And employee is updated and response contains key "Message" and value "Entry updated"

 
  Scenario: Retrieving updated employee
    Given a request is prepared  to retrieve the employee from previous call
    When a GET call is made to retrieve the employee
    Then the status code is 200
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    And retrieved data at "employee" matches data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title    | emp_status    |
      | Rafa          | J               | Nadal        | 1984-05-20   | Male       | Cloud Consultant | Self-Employee |

  Scenario: Partially updating the created employee
    Given a request is prepared to partially update the employee
    When a PATCH call is made to partially update the employee
    Then the status code is 201
    And employee is updated and response contains key "Message" and value "Entry updated"

  Scenario: Retrieving partially updated employee
    Given a request is prepared  to retrieve the employee from previous call
    When a GET call is made to retrieve the employee
    Then the status code is 200
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    And retrieved data at "employee" matches data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title    | emp_status    |
      | Novak         | J               | Nadal        | 1985-11-11   | Male       | Cloud Consultant | Self-Employee |




  Scenario: Deleting the employee
    Given a request is prepared  to delete an employee
    When a DELETE call is made to delete the employee
    Then the status code is 201
    And the retrieved employee ID at "employee[0].employee_id" matches the globally stored employee ID
    And employee is updated and response contains key "message" and value "Entry deleted"
    And retrieved data at "employee" matches data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title    | emp_status    |
      | Novak         | J               | Nadal        | 1985-11-11   | Male       | Cloud Consultant | Self-Employee |
    And verifying the employee is deleted with get call with response containing key "massage" and value "Employee does not exist or you have provided invalid employee_id"
