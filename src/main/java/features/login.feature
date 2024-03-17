@Test
@Login

Feature: Login Test

  Background:
    Given When user is on Sauce Demo Page

  Scenario Outline:Login User with multiple valid credentials

    When User enter valid username "<Username>" and password "<Password>"
    When User click on Login
    Then User is on Home Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |
      | error_user    | secret_sauce |
      | visual_user   | secret_sauce |

    Scenario Outline: Login User with multiple invalid credentials
      When User enter invalid username "<InvalidU>" and password "<InvalidP>"
      When User click on Login
      Then An error message should be displayed
      Examples:
        | InvalidU  | InvalidP |
        | flonisufi | 1234     |
        | isufi123  | baba123  |
        | kingi123  | floni123 |

      Scenario: Logout
        When User enter valid username "standard_user" and password "secret_sauce"
        When User click on Login
        When User check on menu and click Logout
        Then User is redirected to Login Page


