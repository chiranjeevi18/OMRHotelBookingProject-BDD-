package com.amazon.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void reports(String jsonPath) {
		File file = new File("C:\\Users\\USER\\eclipse-workspace\\Day - 13\\AmazonProject\\target");
		Configuration configuration = new Configuration(file, jsonPath);
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "Windows");
		configuration.addClassifications("Version", "334");
		configuration.addClassifications("Year", "2024");
		List<String> jsonFile=new ArrayList<String>();
		jsonFile.add(jsonPath);
		ReportBuilder builder = new ReportBuilder(jsonFile, configuration);
		builder.generateReports();
	}
}
