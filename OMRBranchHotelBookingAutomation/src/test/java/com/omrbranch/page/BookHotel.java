package com.omrbranch.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import io.cucumber.datatable.DataTable;

public class BookHotel extends BaseClass {
	public static String elementGetText;
	public static String orderID;

	public BookHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement bookHotelSuccessMsg;

	@FindBy(xpath = "//a[@id='step1']")
	private WebElement scrollDown;

	@FindBy(id = "own")
	private WebElement clickOwn;

	@FindBy(id = "user_title")
	private WebElement txtSaluation;

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "user_phone")
	private WebElement txtPhoneNo;

	@FindBy(id = "user_email")
	private WebElement txtEmailID;

	@FindBy(id = "gst")
	private WebElement clickGst;

	@FindBy(id = "gst_registration")
	private WebElement txtRegNoGST;

	@FindBy(id = "company_name")
	private WebElement txtCompanyName;

	@FindBy(id = "company_address")
	private WebElement txtCompanyAddress;

	@FindBy(css = "button#step1next")
	private WebElement clickStep1Next;

	@FindBy(id = "other_request")
	private WebElement specialRequest;

	@FindBy(css = "button#step2next")
	private WebElement clickStep2Next;

	@FindBy(xpath = "//h5[text()='Credit/Debit/ATM Card']")
	private WebElement clickCard;

	@FindBy(id = "payment_type")
	private WebElement selectPaymentType;

	@FindBy(id = "card_type")
	private WebElement clickCardType;

	@FindBy(id = "card_no")
	private WebElement txtCardNo;

	@FindBy(id = "card_name")
	private WebElement txtCardName;

	@FindBy(id = "card_month")
	private WebElement selectCardMonth;

	@FindBy(id = "card_year")
	private WebElement clickCardYear;

	@FindBy(id = "cvv")
	private WebElement txtCvv;

	@FindBy(id = "submitBtn")
	private WebElement submitBtn;

	@FindBy(xpath = "//h2[@name='booking-code']/strong")
	private static WebElement bookingCode;

	@FindBy(xpath = "//p/strong")
	private static WebElement bookingHotelName;

	public WebElement getScrollDown() {
		return scrollDown;
	}

	public WebElement getBookHotelSuccessMsg() {
		return bookHotelSuccessMsg;
	}

	public WebElement getClickOwn() {
		return clickOwn;
	}

	public WebElement getTxtSaluation() {
		return txtSaluation;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtPhoneNo() {
		return txtPhoneNo;
	}

	public WebElement getTxtEmailID() {
		return txtEmailID;
	}

	public WebElement getTxtGst() {
		return clickGst;
	}

	public WebElement getTxtRegNoGST() {
		return txtRegNoGST;
	}

	public WebElement getTxtCompanyName() {
		return txtCompanyName;
	}

	public WebElement getTxtCompanyAddress() {
		return txtCompanyAddress;
	}

	public WebElement getClickStep1Next() {
		return clickStep1Next;
	}

	public WebElement getClickGst() {
		return clickGst;
	}

	public WebElement getSpecialRequest() {
		return specialRequest;
	}

	public WebElement getClickStep2Next() {
		return clickStep2Next;
	}

	public WebElement getClickCard() {
		return clickCard;
	}

	public WebElement getSelectPaymentType() {
		return selectPaymentType;
	}

	public WebElement getClickCardType() {
		return clickCardType;
	}

	public WebElement getTXtCardNo() {
		return txtCardNo;
	}

	public WebElement getTxtCardName() {
		return txtCardName;
	}

	public WebElement getSelectCardMonth() {
		return selectCardMonth;
	}

	public WebElement getClickCardYear() {
		return clickCardYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getBookingCode() {
		return bookingCode;
	}

	public WebElement getBookingHotelName() {
		return bookingHotelName;
	}

	public String bookHotelSuccessMessage() {
		String bookHotel = elementGetText(bookHotelSuccessMsg);
		
		String[] split = bookHotel.split(" - ");
		String exp = split[0];
		return exp;
		
		
	}

	public void specialRequestCheckBox() {
		List<WebElement> locatorsByxpath = findLocatorsByxpath(specialRequest);
		for (WebElement special : locatorsByxpath) {
			special.click();
		}

	}

	public void guestDetails(String saluation, String firstName, String lastName, String mobile, String email) {
		clickElement(clickOwn);
		selectByText(txtSaluation, saluation);
		sendkeys(txtFirstName, firstName);
		sendkeys(txtLastName, lastName);
		sendkeys(txtPhoneNo, mobile);
		sendkeys(txtEmailID, email);

	}

	public void gstDetails(String regNo, String companyName, String companyAddress) {
		clickElement(clickGst);
		sendkeys(txtRegNoGST, regNo);
		sendkeys(txtCompanyName, companyName);
		sendkeys(txtCompanyAddress, companyAddress);
		clickElement(clickStep1Next);
	}

	public void otherReq(String otherReq) throws InterruptedException {
		
		sendkeys(specialRequest, otherReq);
		clickElement(clickStep2Next);
		
	}
	public void secondStepClick() {
		clickElement(clickStep2Next);
	}

	public void cardTypePayment(String cardType) throws InterruptedException {
		
		clickElement(clickCard);
		selectByText(selectPaymentType, cardType);
	}

	public void cardDetails(io.cucumber.datatable.DataTable dataTable, int value) {

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> row = asMaps.get(value);
		String card = row.get("card");
		String cardNumber = row.get("cardNumber");
		String NameOnCard = row.get("NameOnCard");
		String month = row.get("month");
		String year = row.get("year");
		String cvv = row.get("cvv");
		selectByText(clickCardType, card);
		sendkeys(txtCardNo, cardNumber);
		sendkeys(txtCardName, NameOnCard);
		selectByText(selectCardMonth, month);
		selectByText(clickCardYear, year);
		sendkeys(txtCvv, cvv);
		submitButton();
	}
	
	public void cardDetailssssss(DataTable dataTable) throws InterruptedException {
	    List<Map<String, String>> rows = dataTable.asMaps();

	    for (Map<String, String> row : rows) {
	        String card = row.get("card");
	        String cardNumber = row.get("cardNumber");
	        String nameOnCard = row.get("NameOnCard");
	        String month = row.get("month");
	        String year = row.get("year");
	        String cvv = row.get("cvv");

	        // Process card details for each row
	        selectByText(clickCardType, card);
	        sendkeys(txtCardNo, cardNumber);
	        sendkeys(txtCardName, nameOnCard);
	        selectByText(selectCardMonth, month);
	        selectByText(clickCardYear, year);
	        sendkeys(txtCvv, cvv);
	        submitButton(); Thread.sleep(5000);
	    }
	}

	public void submitButton() {
		clickElement(submitBtn);
	}

	public static void bookingSuccessMessageAndOrderId() {
		elementGetText = elementGetText(bookingHotelName);
		orderID = elementGetText(bookingCode);
	}
}
