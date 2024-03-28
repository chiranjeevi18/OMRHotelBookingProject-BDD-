package com.amazon.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.amazon.report.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, tags = "@Test" ,plugin = "json:target/amazon.json",features = "src\\test\\resources\\FeatureFile", glue = "com.amazon.step")
public class RunnerClass {

	@AfterClass
	public static void jvmReportOutput() {
		JVMReport.reports("C:\\Users\\USER\\eclipse-workspace\\Day - 13\\AmazonProject\\target\\amazon.json");
	}
}
