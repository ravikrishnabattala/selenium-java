package org.example;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.console.ConsoleLauncher;
import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@Cucumber
@IncludeEngines({"cucumber",
        "junit-jupiter"
})
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.example")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html")
public class TestRunner {

    public static void main(String[] args) {

        String[] testArgs = {
                "--scan-classpath"
        };
        ConsoleLauncher.main(testArgs);

    }
}
