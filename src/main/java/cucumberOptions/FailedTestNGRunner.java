package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt",
glue = "stepDefinitions",monochrome = true,
plugin = {"html:target/cucumber.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestNGRunner extends AbstractTestNGCucumberTests {
}
