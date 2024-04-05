package com.omrbranch.page;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class ExploreHotel extends BaseClass {
	public ExploreHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Explore Hotels']")
	private WebElement exploreHotelsMsg;

	@FindBy(xpath = "//a[contains(text(), 'Welcome Chiran')]")
	private WebElement welComeTxt;

	@FindBy(xpath = "(//div[@class='fliter_box_inner text-center'])[2]")
	private WebElement bookHotelButton;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(xpath = "//span[@id='select2-city-container']")
	private WebElement cityContainer;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement city;

	@FindBy(xpath = "//textarea[@type='search']")
	private WebElement selectRoomTypes;

	@FindBy(xpath = "//input[@class='form-control from hasDatepicker']")
	private WebElement checkInDate;

	@FindBy(xpath = "//input[@class='form-control to hasDatepicker']")
	private WebElement checkOutDate;

	@FindBy(id = "no_rooms")
	private WebElement selectNoRooms;

	@FindBy(id = "no_adults")
	private WebElement selectNoAdults;

	@FindBy(id = "no_child")
	private WebElement selectNoChild;

	@FindBy(id = "hotelsearch_iframe")
	private WebElement switchFrameId;

	@FindBy(id = "searchBtn")
	private WebElement searchButton;

	@FindBy(id = "invalid-state")
	private WebElement selectState;

	@FindBy(id = "invalid-city")
	private WebElement selectCity;

	@FindBy(id = "invalid-check_in")
	private WebElement selectCheckInDate;

	@FindBy(id = "invalid-check_out")
	private WebElement selectCheckOutDate;

	@FindBy(id = "invalid-no_rooms")
	private WebElement selectNoOfRooms;

	@FindBy(id = "invalid-no_adults")
	private WebElement selectNoOfAdults;

	@FindBy(xpath = "//a[@id='room_type']")
	private WebElement allRoomSuccessMsg;

	public WebElement getWelComeTxt() {
		return welComeTxt;
	}

	public WebElement getBookHotelButton() {
		return bookHotelButton;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCityContainer() {
		return cityContainer;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getSelectRoomTypes() {
		return selectRoomTypes;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getSelectNoRooms() {
		return selectNoRooms;
	}

	public WebElement getSelectNoAdults() {
		return selectNoAdults;
	}

	public WebElement getSelectNoChild() {
		return selectNoChild;
	}

	public WebElement getSwitchFrameId() {
		return switchFrameId;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public WebElement getSelectCheckInDate() {
		return selectCheckInDate;
	}

	public WebElement getSelectCheckOutDate() {
		return selectCheckOutDate;
	}

	public WebElement getSelectNoOfRooms() {
		return selectNoOfRooms;
	}

	public WebElement getSelectNoOfAdults() {
		return selectNoOfAdults;
	}

	public WebElement getExploreHotelsMsg() {
		return exploreHotelsMsg;
	}

	public WebElement getAllRoomSuccessMsg() {
		return allRoomSuccessMsg;
	}

	public String welcomeSuccessText() {
		String elementGetText = elementGetText(welComeTxt);
		return elementGetText;
	}
	public String exploreHotelPageSuccessMsg() {
		String elementGetText = elementGetText(exploreHotelsMsg);
		return elementGetText;
	}

	public void selectRoomType(String roomType) throws InterruptedException {
		String[] split = roomType.split("/");
		for (String room : split) {
			insertValueInTextBoxAndEnter(selectRoomTypes, room);
//			selectRoomTypes.sendKeys(room, Keys.ENTER);
		}
	}

	// Scenario 1 Verifying Explore hotel module by entering all room type
	public void searchHotelAllFields(String StateName, String cityName, String roomType, String checkIn,
			String checkOut, String noRooms, String noAdults, String noChild)
			throws AWTException, InterruptedException {
		clickElement(bookHotelButton);
		selectByText(state, StateName);
		Thread.sleep(2000);
		clickElement(cityContainer);
		insertValueInTextBoxAndEnter(city, cityName);
		insertValueInTextBoxAndEnter(selectRoomTypes, roomType);
		setAttributeJS(checkInDate, checkIn);
		setAttributeJS(checkOutDate, checkOut);
		selectByText(selectNoRooms, noRooms);
		selectByText(selectNoAdults, noAdults);
		sendkeys(selectNoChild, noChild);
	}

	// Scenario 2 Verifying Explore hotel module with mandatory fields
	public void searchHotelMandatoryFields(String StateName, String cityName, String checkIn, String checkOut,
			String noRooms, String noAdults) throws AWTException, InterruptedException {
		clickElement(bookHotelButton);
		selectByText(state, StateName);
		Thread.sleep(2000);
		clickElement(cityContainer);
		insertValueInTextBoxAndEnter(city, cityName);
		setAttributeJS(checkInDate, checkIn);
		setAttributeJS(checkOutDate, checkOut);
		selectByText(selectNoRooms, noRooms);
		selectByText(selectNoAdults, noAdults);
	}

	// Scenario 3 Verifying Explore hotel module by entering all room type
	public void searchHotelsByAllRooms(String StateName, String cityName, String roomType, String checkIn,
			String checkOut, String noRooms, String noAdults, String noChild)
			throws AWTException, InterruptedException {
		clickElement(bookHotelButton);
		selectByText(state, StateName);
		Thread.sleep(2000);
		clickElement(cityContainer);
		insertValueInTextBoxAndEnter(city, cityName);
		selectRoomType(roomType);
		setAttributeJS(checkInDate, checkIn);
		setAttributeJS(checkOutDate, checkOut);
		selectByText(selectNoRooms, noRooms);
		selectByText(selectNoAdults, noAdults);
		sendkeys(selectNoChild, noChild);
	}

	// Scenario 4 Verifying Explore hotel module without entering fields
	public void searchButton() {
		switchFrameByWebElement(switchFrameId);
		clickElement(searchButton);
		switchFrameToDefault();
	}

	public String stateNotSelectedMsg() {
		String elementGetText = elementGetText(selectState);
		return elementGetText;
	}

	public String cityNotSelectedMsg() {
		String elementGetText = elementGetText(selectCity);
		return elementGetText;
	}

	public String checkInNotSelectedMsg() {
		String elementGetText = elementGetText(selectCheckInDate);
		return elementGetText;
	}

	public String checkOutNotSelectedMsg() {
		String elementGetText = elementGetText(selectCheckOutDate);
		return elementGetText;
	}

	public String noOfRoomsNotSelectedMsg() {
		String elementGetText = elementGetText(selectNoOfRooms);
		return elementGetText;
	}

	public String noOfAdultNotSelectedMsg() {
		String elementGetText = elementGetText(selectNoOfAdults);
		return elementGetText;
	}
	
	public String getAllRoomSuccessMessage() {
		String elementGetText = elementGetText(allRoomSuccessMsg);
		return elementGetText;
	}
	public void bookHotelClickButton() {
		clickElement(bookHotelButton);
	}

}
