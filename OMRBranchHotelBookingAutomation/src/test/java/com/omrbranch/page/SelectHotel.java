package com.omrbranch.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class SelectHotel extends BaseClass {
	String firstHotelName;
	String firstHotelPrice;

	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement continueButton;

	@FindBy(xpath = "//h5[@class='font35 font-weight-bold mb-4']")
	private WebElement printSelectHotelTxt;

	@FindAll(@FindBy(xpath = "//div[@id='hotellist']//h5"))
	private List<WebElement> hotelList;

	@FindBy(xpath = "(//div[@id='hotellist']//h5)[1]")
	private WebElement firstHotelList;

	@FindBy(xpath = "//div[@id='hotellist']//strong")
	private List<WebElement> priceList;

	@FindBy(xpath = "(//div[@id='hotellist']//strong)[1]")
	private WebElement firstHotelPriceList;

	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement priceDecending;

	@FindBy(xpath = "//label[text()='Name Ascending']")
	private WebElement nameAscending;

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPrintSelectHotelTxt() {
		return printSelectHotelTxt;
	}

	public List<WebElement> getHotelList() {
		return hotelList;
	}

	public List<WebElement> getPriceList() {
		return priceList;
	}

	public WebElement getPriceDecending() {
		return priceDecending;
	}

	public WebElement getNameAscending() {
		return nameAscending;
	}

	public WebElement getFirstHotelList() {
		return firstHotelList;
	}

	public WebElement getFirstHotelPriceList() {
		return firstHotelPriceList;
	}

	public String selectHotelSuccessMsg() {
		String elementGetText = elementGetText(printSelectHotelTxt);
		return elementGetText;
	}

	public void ascendingHotelName() throws InterruptedException {
		clickElement(nameAscending);
		Thread.sleep(2000);
	}

	public void decendingHotelprice() throws InterruptedException {
		clickElement(priceDecending);
		Thread.sleep(2000);
	}

	public void acceptingAlert() {
		acceptAlert();
	}

	public void dismissAlerts() {
		dismissAlert();
	}

	// First Scenario
	public boolean verifyHotelNameSeletedRoomType(String roomType) {
		List<List<WebElement>> hotel = Arrays.asList(hotelList);

		List<Boolean> hotelRef = new ArrayList<Boolean>();

		for (List<WebElement> webElement : hotel) {
			for (WebElement ref : webElement) {
				String eachHotel = ref.getText();
				System.out.println(eachHotel);
				boolean endsWith = eachHotel.endsWith(roomType);
				System.out.println(endsWith);
				hotelRef.add(endsWith);
			}
		}
		boolean contains = hotelRef.contains(false);
		System.out.println(contains);
		return contains;
	}


	// Second Scenario
	public boolean sortedHotelNameAscendingOrder() throws InterruptedException {
		List<List<WebElement>> hotels = Arrays.asList(hotelList);
		
		List<String> act = new ArrayList<String>();
		
		for (List<WebElement> eachHotel : hotels) {
			for (WebElement each : eachHotel) {
				String text = each.getText();
				System.out.println(text);
				act.add(text);
			}
		}
		List<String> ascendingValueStore = new ArrayList<String>();
		for (List<WebElement> eachHotel : hotels) {
			for (WebElement each : eachHotel) {
				String hotelName = each.getText();
				System.out.println(hotelName);
				ascendingValueStore.add(hotelName);
			}
		}
		Collections.sort(ascendingValueStore);
		
		boolean equals = ascendingValueStore.equals(act);
		return equals;
	}

	// Thired Scenario
	public boolean sortedHotelPriceDescendingOrder() {
		List<List<WebElement>> descendingelements = Arrays.asList(priceList);
		List<String> descendingTotalPrice = new ArrayList<String>();
		for (List<WebElement> string : descendingelements) {
			for (WebElement priceList : string) {
				String text = priceList.getText();
				System.out.println(text);
				descendingTotalPrice.add(text);
			}
		}
		Collections.reverse(descendingTotalPrice);
		boolean equals = descendingTotalPrice.equals(descendingelements);
		return equals;
	}

	public void saveFirstHotelNameAndPrice() {

		firstHotelName = elementGetText(printSelectHotelTxt);
		firstHotelPrice = elementGetText(firstHotelPriceList);

	}

	public void clickFirstHotel() {
		clickButtonJS(getContinueButton());
	}
}
