package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {
		
		//"D:\\cucumberFrameworkworkbench\\flexibplus_bdd\\features\\bank_navigation_flow.feature",
		//"D:\\cucumberFrameworkworkbench\\flexibplus_bdd\\features\\Sauce_lab_demo.feature"
		//"D:\\BDDFramework\\flexibplus_bdd\\features\\Bank_sample.feature"
		"D:\\Flexibi\\autoamtionFramworks\\Automation_Framewroks\\Automation_Framewroks\\BDDFramework\\flexibplusBDD\\flexibplus_bdd\\features\\Flexcube_Login.feature"
		
},
dryRun = false, 
glue = {"StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class Runner{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
}