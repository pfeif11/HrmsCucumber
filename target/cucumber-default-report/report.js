$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Dashboard.feature");
formatter.feature({
  "name": "Dashboard menu view for Admin",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged into HRMS with Admin Credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_is_logged_into_HRMS_with_Admin_Credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see dashboard menu is displayed",
  "rows": [
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.DashboardSteps.user_should_see_dashboard_menu_is_displayed(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "");
formatter.after({
  "status": "passed"
});
});