package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/LoginFeature.feature",
		glue = "StepDefination",
		dryRun=false,
		monochrome = true,
		plugin= {"pretty","html:Cucumber-reports/reports1.html"}
		)

public class Run extends AbstractTestNGCucumberTests{
	//this class will be empty
}
