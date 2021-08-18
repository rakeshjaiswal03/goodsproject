package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/BIAL_Report/ACS_BIAL.html",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports" },features = "E:\\OMS-GITHub\\BIAL\\BIAL\\Features", 
		tags ="@BIAL_TC_26_ACS_Registration",
		glue = "StepDefinitions", monochrome = true, strict = false)

    public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {

	}
 



}
