
Feature: Verifying Explore Hotel Page

  Scenario Outline: Verify select hotel by entering all fields in explore hotel module
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"

    Examples: 
      | Username                  | Password  | State      | City       | roomType | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard | 2024-03-26 | 2024-03-29 | 2-Two   | 2-Two   |       2 |

  Scenario Outline: Verifying Explore hotel module with mandatory fields
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering mandatory fields "<State>","<City>","<Check_in>","<Check_out>","<noRooms>" and "<noAdult>"
    Then User should verify after select hotel success message "Select Hotel"

    Examples: 
      | Username                  | Password  | State      | City       | Check_in   | Check_out  | noRooms | noAdult |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | 2024-03-26 | 2024-03-29 | 2-Two   | 2-Two   |

  Scenario Outline: Verifying Explore hotel module by entering all room type
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields include all room type "<State>","<City>","<roomType>","<Check_in>","<Check_out>","<noRooms>","<noAdult>" and "<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    And User should verify after selecting all room type success message "<roomType>"

    Examples: 
      | Username                  | Password  | State      | City       | roomType                            | Check_in   | Check_out  | noRooms | noAdult | noChild |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Deluxe/Suite/Luxury/Studio | 2024-03-26 | 2024-03-29 | 2-Two   | 2-Two   |       2 |

@Explore 
  Scenario Outline: Verifying Explore hotel module without entering fields
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"
    When User without entering any fields
    Then User sould verify without fields success message "Explore Hotels"
    And User should verify error message "Please select state", "Please select city", "Please select Check-in date", "Please select Check-out date", "Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | Username                  | Password  |
      | imchiranjeevi94@gmail.com | Chiran@09 |
