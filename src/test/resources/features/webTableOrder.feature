Feature: Web table order feature


  Scenario: User should be able to place order and order seen in web table

    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "american express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table


  @wip
  Scenario Outline: User should be able to place order and order seen in web table

    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table
    Examples: Famous female scientists
      | productType | quantity | customerName       | customerName  | street | city   | state   | zipCode | cardType | cardNumber       | expDate | expectedName       |
      | MoneyCog    | 2        | Marie Curie        | London Street | London | London | England | 24545   | Visa     | 1111222233334444 | 12/24   | Marie Curie        |
      | Familybea   | 1        | Rosalind Franklin  | London Street | London | London | England | 24545   | Visa     | 1111222233334444 | 12/24   | Rosalind Franklin  |
      | Screenable  | 3        | Lisa Meitner       | London Street | London | London | England | 24545   | Visa     | 1111222233334444 | 12/24   | Lisa Meitner       |
      | MoneyCog    | 4        | Chieng             | London Street | London | London | England | 24545   | Visa     | 1111222233334444 | 12/24   | Chieng             |
      | MoneyCog    | 5        | Barbara MvClintonc | London Street | London | London | England | 24545   | Visa     | 1111222233334444 | 12/24   | Barbara MvClintonc |

    @maleScientist
    Examples: Famous male scientists
      | productType | quantity | customerName          | street    | city   | state   | zipcode | cardType | cardNumber       | expDate | expectedName          |
      | MoneyCog    | 2        | Charles Darwin        | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Charles Darwins        |
      | Familybea   | 3        | Albert Einstein       | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Albert Einstein       |
      | Screenable  | 4        | CV Raman              | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | CV Raman              |
      | MoneyCog    | 5        | Galileo               | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Galileo               |
      | MoneyCog    | 6        | Isaac Newton          | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Isaac Newton          |
      | MoneyCog    | 6        | Arnold Schwarzenegger | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Arnold Schwarzenegger |
