$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/InvalidLogin.feature");
formatter.feature({
  "name": "Login with Invalid Credentials",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Entering multiple invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enters invalid username and password, click login and see error message",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.InvalidLoginSteps.user_enters_invalid_username_and_password_click_login_and_see_error_message(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Entering multiple invalid credentials");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with valid username and without password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid username",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enter_valid_username()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters empty password  and clicks login",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enters_empty_password_and_clicks_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees Password can not be empty error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_sees_Password_can_not_be_empty_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Login with valid username and without password");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login without username and valid password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter empty username",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enter_empty_username()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid password  and clicks login",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enters_valid_password_and_clicks_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees Username can not be empty error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_sees_Username_can_not_be_empty_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Login without username and valid password");
formatter.after({
  "status": "passed"
});
});