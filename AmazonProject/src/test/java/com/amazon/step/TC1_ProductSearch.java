package com.amazon.step;

import com.amazon.base.BaseClass;
import com.amazon.page.ProductSearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_ProductSearch extends BaseClass{

	@Given("User should enter the amazon home page")
	public void user_should_enter_the_amazon_home_page() {
		browseLaunch();
		enterApplicationUrl("https://www.amazon.in/");
		maximizeWindow();
		implicitWait();
	}


	@When("User search the product {string} in search text box")
	public void user_search_the_product_in_search_text_box(String product) {
		ProductSearchPage productSearch = new ProductSearchPage();
		productSearch.searchingProduct(product);
	}



	@Then("User verify the list of search result")
	public void user_verify_the_list_of_search_result() {
		
	}

}
