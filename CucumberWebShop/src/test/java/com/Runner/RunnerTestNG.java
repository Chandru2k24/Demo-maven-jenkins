
package com.Runner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Listeners;

import com.Utilities.ListenerData;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@Listeners(ListenerData.class)

@CucumberOptions(
		plugin = {"pretty" , "html:target/HTMLReport/report.html" , "json:target/JsonReport/report.json" , "rerun:target/failedRerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src/test/resources/features",
		glue = "com.StepDefinitions"
		)

public class RunnerTestNG extends AbstractTestNGCucumberTests{

}
