Feature: Newspapers.com Login Validation

  Scenario Outline: Login to Newspapers.com Homepage

    Given the user is in the Newspaper Homepage
    And the user clicks the Sign-in button
    When the user inputs "<username>" and "<password>"
    And the user clicks the Sign with Newspapers.com button
    Then the user is redirected to Newspaper Dashboard page

    Examples:
      | username          | password  |
      |lourdes100@test.com| Test123!  |