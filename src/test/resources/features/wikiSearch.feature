@wip
Feature: Wiki search functionality
  Agile story: As a user, when I am on the Wikipedia page I should be
  able to search whatever I want and see relevant information

  Scenario: : Wikipedia Search Functionality Title Verification
    Given user is on wikipedia home page
    When user type "Steve Jobs"
    And clicks search button
    Then user sees "Steve Jobs" on wikipedia title

  Scenario: Wikipedia Search Functionality Header Verification
    Given user is on wikipedia home page
    When user type "Steve Jobs"
    And clicks search button
    Then user sees "Steve Jobs" on wikipedia main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on wikipedia home page
    When user type "Steve Jobs"
    And clicks search button
    Then user sees "Steve Jobs" on wikipedia image header