package com.omrbranch.step;

import org.junit.Assert;

import com.omrbranch.page.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep {
	PageObjectManager manager = new PageObjectManager();

	@Then("User should verify hotel names ended with selected {string} successfully")
	public void userShouldVerifyHotelNamesEndedWithSelectedSuccessfully(String roomType) {
		manager.getSelectHotel().verifyHotelNameSeletedRoomType(roomType);
		
	}

	@When("User click the name ascending button")
	public void userClickTheNameAscendingButton() throws InterruptedException {
		manager.getSelectHotel().ascendingHotelName();
		
	}

	@Then("User should verify Hotel names after click the name ascending button if it has sorted in ascending order successfully")
	public void userShouldVerifyHotelNamesAfterClickTheNameAscendingButtonIfItHasSortedInAscendingOrderSuccessfully() throws InterruptedException {
		manager.getSelectHotel().sortedHotelNameAscendingOrder();
	}

	@When("User click the price high-low option button")
	public void userClickThePriceHighLowOptionButton() throws InterruptedException {
		manager.getSelectHotel().decendingHotelprice();
	}

	@Then("User should verify hotel price after click the price high-low option button if it is sorted descending order successfully")
	public void userShouldVerifyHotelPriceAfterClickThePriceHighLowOptionButtonIfItIsSortedDescendingOrderSuccessfully() {
		manager.getSelectHotel().sortedHotelPriceDescendingOrder();
	}

	@When("User select the first hotel name and save the hotel name and hotel price")
	public void userSelectTheFirstHotelNameAndSaveTheHotelNameAndHotelPrice() {
		manager.getSelectHotel().clickFirstHotel();
		
	}

	@When("User accept the alert to select hotel")
	public void userAcceptTheAlertToSelectHotel() {
		manager.getSelectHotel().acceptingAlert();
	}

	@Then("User should verify {string} success message after navigate to book hotel")
	public void userShouldVerifySuccessMessageAfterNavigateToBookHotel(String expBookHotelSuccessMsg) {
		String bookHotelSuccessMessage = manager.getBookHotel().bookHotelSuccessMessage();
		System.out.println(bookHotelSuccessMessage);
		Assert.assertEquals("Verified Book Hotel Success Message", bookHotelSuccessMessage, expBookHotelSuccessMsg);
		
	}

	@When("User cancel the alert to select hotel")
	public void userCancelTheAlertToSelectHotel() {
		manager.getSelectHotel().dismissAlerts();
	}




}
