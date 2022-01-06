Feature: Newspapers.com Search Validation

  Scenario Outline: Verify Newspapers User Dashboard contents

    Given the user is in the Newspaper Homepage
    And the user is logged-in "<username>" and "<password>" to Newspapers page
    When the user is on Newspaper Dashboard page
    And the user enters "<keyword>" in the Keyword field
    And the user selects "<year>" in the Date datepicker
    And the user selects "<location>" in the Location dropdown
    And the user clicks the search button
    Then the search results for "<keyword>" is displayed

      Examples:
      | username          | password  | keyword                | year      | location |
      |lourdes100@test.com| Test123!  | Democrat and Chronicle |  2000s    | New York |