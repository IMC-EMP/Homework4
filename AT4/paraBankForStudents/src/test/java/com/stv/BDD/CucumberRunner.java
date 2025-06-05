package com.stv.BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/stv/BDD",
        glue = "com.stv.BDD",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class CucumberRunner {
}