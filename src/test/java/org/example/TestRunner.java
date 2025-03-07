package org.example;


import io.cucumber.junit.platform.engine.Constants;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.console.ConsoleLauncher;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features")
//@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.example.steps")

//@Cucumber
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "org.example")
public class TestRunner {

    public static void main(String[] args) {

        String[] testArgs = {
                "--scan-classpath"
        };
        ConsoleLauncher.main(testArgs);

    }
}
