@GoogleSearch
Feature: Check addition in Google caluculator from search
  In order to verify that google calculator work correctly
  As a user of google
  I should be able to get coorect addition result


  @sharedselenium
Scenario Outline: Addition functionality
  Given user navigates to google.com
  When user enters "<input>" in serach box
  Then Result should be "<result>"

Examples:
  |input  | result |
  | 20+20 | 40 |
  | 3-2 | 1 |
