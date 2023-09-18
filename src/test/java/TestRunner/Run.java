package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { ".//Features/LoginFeature.feature"},
		//features = ".//Features/",
		glue = "StepDefination",
		dryRun=false,
		monochrome = true,
		tags="@Sanity", //and @regression",//Scenarios under @sanity tag will be executed 
		plugin= {"pretty","html:Cucumber-reports/reports1.html"}
		)

//plugin= {"pretty","json:Cucumber-reports/reports_json.json"}
//plugin= {"pretty","html:Cucumber-reports/reports1.html"}
/*plugin= {"pretty","junit:Cucumber-reports/reports_xml.xml"
		,"json:Cucumber-reports/reports_json.json"
		,"html:Cucumber-reports/reports1.html"}*/


public class Run extends AbstractTestNGCucumberTests{
	//this class will be empty
}
