@Test
Feature: Explore Amazon Search Page

  Scenario: User should search the product in amazon search box
    Given User should enter the amazon home page
    When User search the product "Laptop" in search text box
    Then User verify the list of search result
