Feature: Verifying OMR Branch change booking

  Scenario Outline: Verifying change booking module by changing checkin date for created orderID
    Given User is in OMR Branch hotel page
    When User enter "<username>" and "<password>"
    Then User should verify after login success message "Welcome Chiran"
    When User search by entering all the fields "<state>","<city>","<roomType>","<checkin>","<checkout>","<noRooms>","<noAdult>"and"<noChild>"
    Then User should verify after select hotel success message "Select Hotel"
    When User select the first hotel name and save the hotel name and hotel price
    And User accept the alert to select hotel
    Then User should verif "Book Hotel" success message after navigate to book hotel
    When User add the guest details "<salution>","<firstname>","<lastname>","<mobile>"and"<email>"
    And User add GST details "<reqNo>","<companyName>"and"<companyAddress>"
    And User add special request "<otherReq>"
    And User add the payment details "<cardType>"
      | card       | cardNumber       | NameOnCard  | month | year | cvv |
      | visa       | 5555555555552222 | chiranjeevi | Oct   | 2026 | 222 |
      | masterCard | 5666323243232390 | chiranjeevi | Oct   | 2026 | 222 |
      | amex       | 5666323243232316 | chiranjeevi | Oct   | 2026 | 222 |
      | masterCard | 5666323243232332 | chiranjeevi | Oct   | 2026 | 222 |
    Then User should verify after booking hotel success message  "Booking is Confirmed" and save the orderID
    And User should verify after booking selected hotel name is present successfully
    When User navigate to my booking page
    Then User should verify the success message "Booking" after navigate to booking page
    When User search the orderId with saved orderId
    Then User should verify the same orderId is present successfully
    And User should verify the same hotel name is present successfully
    And User should verify the same hotel price present successfylly
    When User edit the booking by changing the checkin Date
    Then User should verify after editing success message "Booking updated successfully"

    Examples: 
      | username                  | password  | state      | city       | roomType                            | checkin    | checkout   | noRooms | noAdult | noChild | Salutation | firstName   | lastName | Mobile     | email                     | regNo      | companyName            | companyAddress | otherReq  | cardType  | editCheckin |
      | imchiranjeevi94@gmail.com | Chiran@09 | Tamil Nadu | Puducherry | Standard/Duluxe/Suite/Luxury/Studio | 2024-03-20 | 2024-03-24 | 2-Two   | 2-Two   |       4 | Mr.        | Chiranjeevi | R        | 8220549878 | imchiranjeevi94@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Lake View | DebitCard | 2024-03-03  |

  Scenario Outline: Verifying change booking module by changing checkin date for first orderID
    Given User is in OMR Branch hotel page
    When User enter "<username>" and "<password>"
    Then User should verify after login success message "Welcome Chiran"
    When User navigate to my booking page
    Then User should verify the success message "Booking" after navigate to booking page
    When User edit the booking by changing the checkin Date
    Then User should verify after editing success message "Booking updated successfully"

    Examples: 
      | username                  | password  | EditCheckin |
      | imchiranjeevi94@gmail.com | Chiran@09 | 2024-03-03  |

  Scenario Outline: Verifying change booking module by changing checkin date for existing orderID
    Given User is in OMR Branch hotel page
    When User enter "<username>" and "<password>"
    Then User should verify after login success message "Welcome Chiran"
    When User navigate to my booking page
    Then User should verify the success message "Booking" after navigate to booking page
    When User save the orderID the existing orderID
    And User search the existing orderID
    And User edit the booking by changing the checkin date
    Then User should verify after editing success message "Booking updated successfully"
    And User should verify the orderID after editing old orderID present successfully

    Examples: 
      | username                  | password  | EditCheckin |
      | imchiranjeevi94@gmail.com | Chiran@09 | 2024-03-03  |
