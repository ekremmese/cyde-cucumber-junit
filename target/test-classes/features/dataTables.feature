Feature: Examples of Cucumber data table implementations

  @wip
  Scenario: Lists of fruits I like
    Then user should see fruits I like
      | Apple    |
      | Cucumber |
      | Orange   |
      | Grape    |
      | Banana   |