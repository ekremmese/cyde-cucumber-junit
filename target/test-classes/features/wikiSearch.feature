Feature: Wiki search functionality
  Agile story: As a user, when I am on the Wikipedia page I should be
  able to search whatever I want and see relevant information

  Scenario:  Wikipedia Search Functionality Title Verification
    Given user is on wikipedia home page
    When user type "Steve Jobs"
    And clicks search button
    Then user sees "Steve Jobs" on wikipedia title
@scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Header Verification
    Given user is on wikipedia home page
    When user type "<searchValue>"
    And clicks search button
    Then user sees "<expectedTitle>" on wikipedia main header
    Then user sees "<expectedMainHeader>" on wikipedia title

    Examples: search values we are going to be using in this scenario is as below
      | searchValue    | expectedTitle  | expectedMainHeader |
      | Steve Jobs     | Steve Jobs     | Steve Jobs         |
      | Bob Marley     | Bob Marley     | Bob Marley         |
      | Antony Hopkins | Antony Hopkins | Antony Hopkins     |
      | Lady Gaga      | Lady Gaga      | Lady Gaga          |


  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on wikipedia home page
    When user type "Steve Jobs"
    And clicks search button
    Then user sees "Steve Jobs" on wikipedia image header