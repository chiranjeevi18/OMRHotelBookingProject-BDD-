
Feature: Verifying OMR Branch Login Module
 @Login
  Scenario Outline: Verifying login Module with valid Credentials
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify after login success message "Welcome Chiran"

    Examples: 
      | Username                  | Password  |
      | imchiranjeevi94@gmail.com | Chiran@09 |

  Scenario Outline: Verifying login Module with valid Credentials using Enter Keyword
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>" with enter key
    Then User should verify after login success message "Welcome Chiran"

    Examples: 
      | Username                  | Password  |
      | imchiranjeevi94@gmail.com | Chiran@09 |

  Scenario Outline: Verifying login Module with Invalid Credentials
    Given User in OMR branch hotel page
    When User enter "<Username>" and "<Password>"
    Then User should verify error message after click login button "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | Username                  | Password  |
      | imchiranjeevi94@gmail.com | Chiran@08 |
