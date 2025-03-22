package com.elpais.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features",  // Path to feature files
    glue = "com.elpais.steps",                 // Path to step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"},  // Reporting plugins
    tags = "@scraping"  // Run tests tagged with @scraping
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
