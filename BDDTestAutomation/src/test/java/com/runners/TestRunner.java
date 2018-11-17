package com.runners;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun=true,features = "src/test/resources/functionalTests",
        glue= {"com.stepDefinitions"}, tags={"@demo"}
)

public class TestRunner {

}