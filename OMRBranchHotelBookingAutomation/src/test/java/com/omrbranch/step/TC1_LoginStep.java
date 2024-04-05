package com.omrbranch.step;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import com.omrbranch.base.BaseClass;
import com.omrbranch.page.PageObjectManager;

import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass {
	PageObjectManager manager = new PageObjectManager();
	@Given("User in OMR branch hotel page")
	public void userInOMRBranchHotelPage() throws FileNotFoundException, IOException {
		getDriver(getProperityFileValue("browser"));
		enterApplicationUrl(getProperityFileValue("url"));
		maximizeWindow();
		implicitWait();
	}

	@When("User enter {string} and {string}")
	public void userEnterAnd(String userName, String passWord) {
		manager.getLoginPage().loginWithButton(userName, passWord);
	}

	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMsg) {
		String successText = manager.getExploreHotel().welcomeSuccessText();
		Assert.assertEquals("Verify Welcome Success Message", expLoginSuccessMsg, successText);
		
	}

	@When("User enter {string} and {string} with enter key")
	public void userEnterAndWithEnterKey(String userName, String passWord) throws AWTException {
		manager.getLoginPage().loginWithEnter(userName, passWord);
	}

	@Then("User should verify error message after click login button {string}")
	public void userShouldVerifyErrorMessageAfterClickLoginButton(String expLoginErrorTextMsg) {
		String getloginErrorTextMsgs = manager.getLoginPage().printErrorLoginMessage();
		boolean contains = getloginErrorTextMsgs.contains(expLoginErrorTextMsg);
		Assert.assertTrue("Verify After login error message", contains);
	}
}
