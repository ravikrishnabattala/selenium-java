package org.example;


import org.junit.platform.console.ConsoleLauncher;

public class TestRunner {

    public static void main(String[] args) {

        String[] testArgs = {
                "--scan-classpath"
        };
        ConsoleLauncher.main(testArgs);

    }
}
