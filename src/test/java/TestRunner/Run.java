package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//Features/LoginFeature.feature",".//Features/Customers.feature"},
		
		
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		tags="@Sanity",
		//plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class Run extends AbstractTestNGCucumberTests{
//this class will be empty
}

//plugin = {"pretty","json:target/cucumber-reports/report_json.json"}
//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
//plugin = {"pretty","junit:target/cucumber-reports/report_xml.xml",
//"html:target/cucumber-reports/reports1.html",
//"json:target/cucumber-reports/report_json.json"}

//"@Sanity or @regression"

//features = ".//Features/Customers.feature",		
		//features = ".//Features/",