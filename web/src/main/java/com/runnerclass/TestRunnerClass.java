package com.runnerclass;
import java.io.File;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin ={ "pretty",
	"json:target/json/chrome/cucumber.json",
	"html:target/html/chrome" },
		 features = "feature",glue = "com.stepdefn", tags = {
		"@TC_004"},
         monochrome = true
)

public class TestRunnerClass  extends AbstractTestNGCucumberTests

//public class copyRunnerClass4 
{
 
}


