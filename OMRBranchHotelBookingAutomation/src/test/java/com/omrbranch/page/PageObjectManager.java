package com.omrbranch.page;

public class PageObjectManager {
	private LoginPage loginPage;
	private ExploreHotel exploreHotel;
	private SelectHotel selectHotel;
	private BookHotel bookHotel;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public ExploreHotel getExploreHotel() {
		return (exploreHotel == null) ? exploreHotel = new ExploreHotel() : exploreHotel;
	}

	public SelectHotel getSelectHotel() {
		return (selectHotel == null) ? selectHotel = new SelectHotel() : selectHotel;
	}

	public BookHotel getBookHotel() {
		return (bookHotel == null) ? bookHotel = new BookHotel() : bookHotel;
	}

}
