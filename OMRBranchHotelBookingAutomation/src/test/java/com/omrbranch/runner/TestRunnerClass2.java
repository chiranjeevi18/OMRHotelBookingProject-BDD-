package com.omrbranch.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, tags = "@Explore", snippets = SnippetType.CAMELCASE, features = "src\\test\\resources\\Features", glue = "com.omrbranch.step", dryRun = false)
public class TestRunnerClass2 {

}
