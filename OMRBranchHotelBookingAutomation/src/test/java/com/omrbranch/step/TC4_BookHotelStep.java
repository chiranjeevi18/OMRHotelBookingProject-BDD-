package com.omrbranch.step;

import com.omrbranch.page.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep {
	PageObjectManager manager = new PageObjectManager();

	@When("User add the guest details {string},{string},{string},{string} and {string}")
	public void userAddTheGuestDetailsAnd(String salution, String firstname, String lastname, String mobile,
			String email) {
		manager.getBookHotel().guestDetails(salution, firstname, lastname, mobile, email);
	}

	@When("User add GST details {string},{string} and {string}")
	public void userAddGSTDetailsAnd(String reqNo, String companyName, String companyAddress) {
		manager.getBookHotel().gstDetails(reqNo, companyName, companyAddress);
	}

	@When("User add special request {string}")
	public void userAddSpecialRequest(String otherReq) throws InterruptedException {
		manager.getBookHotel().otherReq(otherReq);
	}

	@When("User add the payment details {string}")
	public void userAddThePaymentDetails(String cardType, io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		manager.getBookHotel().cardTypePayment(cardType);
		manager.getBookHotel().cardDetails(dataTable, 0);

	}

	@Then("User should verify after booking hotel success message {string} and save the orderID")
	public void userShouldVerifyAfterBookingHotelSuccessMessageAndSaveTheOrderID(String expBookingConfirmMsg) {

	}

	@Then("User should verify after booking selected hotel name is present successfully")
	public void userShouldVerifyAfterBookingSelectedHotelNameIsPresentSuccessfully() {
	}

	@When("User click next without entering special request")
	public void userClickNextWithoutEnteringSpecialRequest() {
		manager.getBookHotel().secondStepClick();
	}

}
