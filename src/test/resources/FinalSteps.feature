Feature: Ticket reservation

  Scenario: Create a reservation
    Given I am on home page
    When I selected departure airport RIX
    And I selected arrival airport BCN
    And I click on GO button
    Then registration page appears

    When I fill registration form with:
      | name          | Jurijs     |
      | surname       | Uljanovs   |
      | discountCode  | 12345      |
      | personCount   | 2          |
      | childrenCount | 0          |
      | luggageCount  | 1          |
      | departureDate | 16-05-2018 |
    And I click on Get Price button
    Then I get price for current flight: 220 EUR

    When I click on Book button
    Then seat selection page appeared

    When I select desired seat 1
    Then seat confirmation message appears

    When I click on Book button again
    Then reservation confirmation page appears

    When I request reservations list
    Then my reservation is in this list
