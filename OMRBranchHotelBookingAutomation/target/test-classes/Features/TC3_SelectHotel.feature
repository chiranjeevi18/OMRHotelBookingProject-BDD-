Feature: Verifying Select Hotel Page

  Scenario Outline: Verify if filter listed same are checked in and hotel names end with same selected room type.
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    And User should verify hotel names ended with selected "<roomType>" successfully

    Examples: 
      | Username                  | Password  | State      | City       | roomType | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Deluxe   | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 |

@SelectHotel
  Scenario Outline: Verify if hotel names are sorted in ascending order in explore hotel page
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields include all room type "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    When User click the name ascending button
    Then User should verify Hotel names after click the name ascending button if it has sorted in ascending order successfully

    Examples: 
      | Username                  | Password  | State      | City       | roomType                            | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Deluxe/Suite/Luxury/Studio | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 |
  
  Scenario Outline: Verify if hotel price is sorted in descending order in explore hotel page
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields include all room type "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    When User click the price high-low option button
    Then User should verify hotel price after click the price high-low option button if it is sorted descending order successfully

    Examples: 
      | Username                  | Password  | State      | City       | roomType                            | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Deluxe/Suite/Luxury/Studio | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 |

  Scenario Outline: Verify select hotel module by accepting alert
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields include all room type "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    When User select the first hotel name and save the hotel name and hotel price
    And User accept the alert to select hotel
    Then User should verify "Book Hotel" success message after navigate to book hotel

    Examples: 
      | Username                  | Password  | State      | City       | roomType                            | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Deluxe/Suite/Luxury/Studio | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 |

  Scenario Outline: Verifying select hotel by giving cancel to alert
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields include all room type "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    When User select the first hotel name and save the hotel name and hotel price
    And User cancel the alert to select hotel
    Then User should verify after select hotel success message "Select Hotel"

    Examples: 
      | Username                  | Password  | State      | City       | roomType                            | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Deluxe/Suite/Luxury/Studio | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 |
