package com.hrms.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue="com/hrms/steps",
		dryRun=false, //if set to true it will quickly scan all the gherkin steps have implementation code and no actual implementation is done
		monochrome=true,
		
		//tags = "@smoke" or"@sprint13", //OR
		tags= "@regression" //AND
		,plugin= {"pretty",
				"html:target/cucumber-default-report",
		"json:target/cucumber.json"
		
		}
		
		)



public class RegressionRunner {

}
