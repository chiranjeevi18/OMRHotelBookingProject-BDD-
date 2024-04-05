package com.omrbranch.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class ChangeBooking extends BaseClass {
	
	public ChangeBooking() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='My Booking']")
	private WebElement myBooking;
	
	@FindBy(xpath = "//h4")
	private WebElement bookings;
	
	@FindBy(css = "input.form-control.w-50.d-inline-block")
	private WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='room-code']/span")
	private WebElement bookedRoomCode;
	
	@FindBy(xpath = "//h5[contains(text(),'Hotel')]")
	private WebElement bookedHotelName;
	
	@FindBy(xpath = "//strong[@class='total-prize']")
	private WebElement bookedHotelPrice;
	
	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement editButton;
	
	@FindBy(name = "check_in")
	private WebElement modifyCheckIn;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//ul//li[@class='alertMsg']")
	private WebElement changeHotelalertMsg;

	public WebElement getMyBooking() {
		return myBooking;
	}

	public WebElement getBookings() {
		return bookings;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getBookedRoomCode() {
		return bookedRoomCode;
	}

	public WebElement getBookedHotelName() {
		return bookedHotelName;
	}

	public WebElement getBookedHotelPrice() {
		return bookedHotelPrice;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getModifyCheckIn() {
		return modifyCheckIn;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getChangeHotelalertMsg() {
		return changeHotelalertMsg;
	}
	
	public void clickMyBooking() {
		clickElement(myBooking);
	}
	public void bookingSuccessMsg() {
		elementGetText(bookings);
	}
	public void orderIDToString() {
		
		
	}
	public void changeCheckInDateForCreatedOrderID(String editCheckin) {
		String orderID = BookHotel.orderID;
		String searchOrderID = orderID.replace("#", "");
		sendkeys(searchBox, searchOrderID);
		elementGetText(bookedRoomCode);
		elementGetText(bookedHotelName);
		elementGetText(bookedHotelPrice);
		clickElement(editButton);
		sendKeysByJS(modifyCheckIn, editCheckin);
		clickElement(confirmButton);
		elementGetText(changeHotelalertMsg);
	}
	public void changeCheckInDateForFirstOrderID(String editCheckin) {
		String firstOrder = elementGetText(bookedHotelName);
		String searchOrderID = firstOrder.replace("#", "");
		sendkeys(searchBox, searchOrderID);
		elementGetText(bookedRoomCode);
		elementGetText(bookedHotelName);
		elementGetText(bookedHotelPrice);
		clickElement(editButton);
		sendKeysByJS(modifyCheckIn, editCheckin);
		clickElement(confirmButton);
		elementGetText(changeHotelalertMsg);
	}
	
	
	
	
	
	
	
	
	
	
	
}
