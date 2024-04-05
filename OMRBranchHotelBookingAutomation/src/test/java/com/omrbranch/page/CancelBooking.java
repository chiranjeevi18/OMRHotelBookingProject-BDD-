package com.omrbranch.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class CancelBooking extends BaseClass{
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Welcome Chiran')]")
	private WebElement welcome;
	
	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	private WebElement myAccount;
	
	@FindBy(xpath = "//h4")
	private WebElement myBookingText;
	
	@FindBy(xpath = "//div[@class='room-code']/span")
	private WebElement bookedRoomCode;
	
	@FindBy(xpath = "//h5[contains(text(),'Hotel')]")
	private WebElement bookedHotelName;
	
	@FindBy(xpath = "//strong[@class= 'total-prize']")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//a[text()= 'Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//ul//li[@class= 'alertMsg']")
	private WebElement cancelAlertMsg;

	public WebElement getWelcome() {
		return welcome;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getMyBookingText() {
		return myBookingText;
	}

	public WebElement getBookedRoomCode() {
		return bookedRoomCode;
	}

	public WebElement getBookedHotelName() {
		return bookedHotelName;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getCancelAlertMsg() {
		return cancelAlertMsg;
	}
	
	
}
