	package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { ".//Features/LoginFeature.feature",".//Features/Customer.feature"},
		//features = ".//Features/",
		glue = "StepDefination",
		dryRun=false,
		monochrome = true,
		tags="@Sanity",//Scenarios under @sanity tag will be executed 
	//	plugin= {"pretty","html:Cucumber-reports/reports1.html"}
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//plugin= {"pretty","json:Cucumber-reports/reports_json.json"}
//plugin= {"pretty","html:Cucumber-reports/reports1.html"}
/*plugin= {"pretty","junit:Cucumber-reports/reports_xml.xml"
		,"json:Cucumber-reports/reports_json.json"
		,"html:Cucumber-reports/reports1.html"}*/


public class Run extends AbstractTestNGCucumberTests{
	//this class will be empty
}
