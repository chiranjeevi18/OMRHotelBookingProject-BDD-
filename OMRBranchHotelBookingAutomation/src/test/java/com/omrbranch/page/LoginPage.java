package com.omrbranch.page;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class LoginPage extends BaseClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement txtUserName;
	
	@FindBy(name="pass")
	private WebElement txtPassWord;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement clickButton;
	
	@FindBy(id = "errorMessage")
	private WebElement loginErrorTextMsg;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getClickButton() {
		return clickButton;
	}

	public WebElement getloginErrorTextMsgs() {
		return loginErrorTextMsg;
	}
	//Scenario 1
	public void loginWithButton(String Username, String Password) {
		sendkeys(txtUserName, Username);
		sendkeys(txtPassWord, Password);
		clickElement(clickButton);
	}
	//Scenario 2
	public void loginWithEnter(String userName, String passWord) throws AWTException {
		sendkeys(txtUserName, userName);
		sendkeys(txtPassWord, passWord);
		enterKey();
	}
	//Scenario 3 for error printing
	public String printErrorLoginMessage() {
		String elementGetText = elementGetText(loginErrorTextMsg);
		return elementGetText;
	}
}
