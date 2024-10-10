package com.example;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
//        plugin = {"pretty", "json:target/cucumber-reports.json"},
//        plugin = {"pretty", "junit:target/cucumber-reports.xml"},
        monochrome = true
)
public class RunCucumberTest {
}
