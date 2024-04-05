package com.omrbranch.page;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.omrbranch.base.BaseClass;

import io.cucumber.java.Before;

public class Hooks extends BaseClass{
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getProperityFileValue("browser"));
		enterApplicationUrl(getProperityFileValue("url"));
		maximizeWindow();
		implicitWait();
	}
	public void afterScenario() {
	}
	
}
