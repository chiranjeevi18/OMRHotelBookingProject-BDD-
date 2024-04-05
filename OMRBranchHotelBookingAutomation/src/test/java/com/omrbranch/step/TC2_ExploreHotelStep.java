package com.omrbranch.step;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.omrbranch.page.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_ExploreHotelStep {
	PageObjectManager manager = new PageObjectManager();

	@When("User search by entering all the fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchByEnteringAllTheFieldsAnd(String State, String City, String roomType, String Check_in,
			String Check_out, String noRooms, String noAdult, String noChild)
			throws AWTException, InterruptedException {
		manager.getExploreHotel().searchHotelAllFields(State, City, roomType, Check_in, Check_out, noRooms, noAdult,
				noChild);
		manager.getExploreHotel().searchButton();
	}

	@Then("User should verify after select hotel success message {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessage(String expSelectHotelSuccessMsg)
			throws InterruptedException {
		String actSelectHotelSuccessMsg = manager.getSelectHotel().selectHotelSuccessMsg();
		System.out.println(actSelectHotelSuccessMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expSelectHotelSuccessMsg, actSelectHotelSuccessMsg);
		Thread.sleep(3000);
	}

	@When("User search by entering mandatory fields {string},{string},{string},{string},{string} and {string}")
	public void userSearchByEnteringMandatoryFieldsAnd(String State, String City, String Check_in, String Check_out,
			String noRooms, String noAdult) throws AWTException, InterruptedException {
		manager.getExploreHotel().searchHotelMandatoryFields(State, City, Check_in, Check_out, noRooms, noAdult);
		manager.getExploreHotel().searchButton();
	}

	@When("User search by entering all the fields include all room type {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchByEnteringAllTheFieldsIncludeAllRoomTypeAnd(String State, String City, String roomType,
			String Check_in, String Check_out, String noRooms, String noAdult, String noChild)
			throws AWTException, InterruptedException {
		manager.getExploreHotel().searchHotelsByAllRooms(State, City, roomType, Check_in, Check_out, noRooms, noAdult,
				noChild);
		manager.getExploreHotel().searchButton();
	}

	@Then("User should verify after selecting all room type success message {string}")
	public void userShouldVerifyAfterSelectingAllRoomTypeSuccessMessage(String expAllRoomSuccessMsg) {
		String allRoomSuccessMessage = manager.getExploreHotel().getAllRoomSuccessMessage();
		Assert.assertEquals("Verify Select Hotel success Message", expAllRoomSuccessMsg, allRoomSuccessMessage);

	}

	@When("User without entering any fields")
	public void userWithoutEnteringAnyFields() {
		manager.getExploreHotel().bookHotelClickButton();
		manager.getExploreHotel().searchButton();
	}

	@Then("User sould verify without fields success message {string}")
	public void userSouldVerifyWithoutFieldsSuccessMessage(String expExploreHotelMsg) {
		String exploreHotelsMsg = manager.getExploreHotel().exploreHotelPageSuccessMsg();
		Assert.assertEquals("Verify Select Hotel success Message", expExploreHotelMsg, exploreHotelsMsg);

	}

	@Then("User should verify error message {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMessageAnd(String expStateNotSelect, String expCityNotSelect, String expNoCheckin,
			String expNoCheckout, String expNoNumberRooms, String expNoNumberAdult) {
		String actStateNotSelectedMsg = manager.getExploreHotel().stateNotSelectedMsg();
		System.out.println(actStateNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expStateNotSelect, actStateNotSelectedMsg);
		String actCityNotSelectedMsg = manager.getExploreHotel().cityNotSelectedMsg();
		System.out.println(actCityNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expCityNotSelect, actCityNotSelectedMsg);
		String actCheckInNotSelectedMsg = manager.getExploreHotel().checkInNotSelectedMsg();
		System.out.println(actCheckInNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expNoCheckin, actCheckInNotSelectedMsg);
		String actCheckOutNotSelectedMsg = manager.getExploreHotel().checkOutNotSelectedMsg();
		System.out.println(actCheckOutNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expNoCheckout, actCheckOutNotSelectedMsg);
		String actNoOfRoomsNotSelectedMsg = manager.getExploreHotel().noOfRoomsNotSelectedMsg();
		System.out.println(actNoOfRoomsNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expNoNumberRooms, actNoOfRoomsNotSelectedMsg);
		String actNoOfAdultNotSelectedMsg = manager.getExploreHotel().noOfAdultNotSelectedMsg();
		System.out.println(actNoOfAdultNotSelectedMsg);
		Assert.assertEquals("Verify Select Hotel success Message", expNoNumberAdult, actNoOfAdultNotSelectedMsg);
	}

}
