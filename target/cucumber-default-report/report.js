$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ModifyPersonalDetails.feature");
formatter.feature({
  "name": "Modify Personal Details",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@modify"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid admin credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_admin_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigates_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user searches for employee with id number \"11331\" and click edit button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.ModifyPersonalDetailsSteps.user_searches_for_employee_with_id_number_and_click_edit_button(java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d84.0.4147.89)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-RVDVF0F\u0027, ip: \u0027192.168.0.199\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.89, chrome: {chromedriverVersion: 84.0.4147.30 (48b3e868b4cc0..., userDataDir: C:\\Users\\pfeif\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:57174}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 576ee2dab8589428baec670c018f82a1\n*** Element info: {Using\u003did, value\u003dbtnSave}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.toString(Unknown Source)\r\n\tat java.lang.String.valueOf(String.java:2994)\r\n\tat java.lang.StringBuilder.append(StringBuilder.java:131)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.toString(ExpectedConditions.java:683)\r\n\tat java.lang.String.valueOf(String.java:2994)\r\n\tat java.lang.StringBuilder.append(StringBuilder.java:131)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:268)\r\n\tat com.hrms.utils.CommonMethods.waitForClickability(CommonMethods.java:211)\r\n\tat com.hrms.utils.CommonMethods.click(CommonMethods.java:219)\r\n\tat com.hrms.steps.ModifyPersonalDetailsSteps.user_searches_for_employee_with_id_number_and_click_edit_button(ModifyPersonalDetailsSteps.java:22)\r\n\tat ✽.user searches for employee with id number \"11331\" and click edit button(file:///C:/Users/pfeif/eclipse-workspace/Hrms/src/test/resources/features/ModifyPersonalDetails.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user modifies employee personal details",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.ModifyPersonalDetailsSteps.user_modifies_employee_personal_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user save modifications and takes \"modifyDetails\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.ModifyPersonalDetailsSteps.user_save_modifications_and_takes(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d84.0.4147.89)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-RVDVF0F\u0027, ip: \u0027192.168.0.199\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.89, chrome: {chromedriverVersion: 84.0.4147.30 (48b3e868b4cc0..., userDataDir: C:\\Users\\pfeif\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:57174}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 576ee2dab8589428baec670c018f82a1\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:295)\r\n\tat com.hrms.utils.CommonMethods.takeScreenshot(CommonMethods.java:261)\r\n\tat com.hrms.steps.Hooks.end(Hooks.java:24)\r\n",
  "status": "failed"
});
});