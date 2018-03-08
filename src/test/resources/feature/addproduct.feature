Feature: verify add product to cart
  In order to verify the add computers to cart
  as a user of nop commerce
  able to see the add computer in cart

  Scenario: Open notebook details
    Given user opens nopCommerce home page
    When user clicks computers from top menu
    And clicks Notebooks tile
    Then avialable notebooks should be shown

  Scenario: Add note book to cart
    Given user in "notebooks" page
    And apply corei7 filter
    When click on "Lenovo Thinkpad" note book
    Then "Lenovo Thinkpad" deatils page should be shown
    When click on add to cart and move to cart
    Then "Lenovo Thinkpad" should be added to cart
