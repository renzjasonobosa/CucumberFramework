Feature: Newspapers.com Account Features validation

  Scenario Outline: Verify Edit Profile Functionality

    Given the user is in the Newspaper Homepage
    And the user is logged-in "<username>" and "<password>" to Newspapers page
    When the user navigates to Edit Profile page
    And the user enters "<memberName>" in the Member name field
    And the user enters "<state>" in the State/Province field
    And the user selects "<country>" in Country dropdown
    And the user enters "<aboutMeText>" in About me field
    And the user clicks the Save Changes button
    Then the Edit profile success notification is displayed
    And the Member name field value is "<memberName>"
    And the State/Province field value is "<state>"
    And the Country dropdown value is "<country>"
    And the About me field value is "<aboutMeText>"

      Examples:
      | username          | password  | memberName  | state     | country       | aboutMeText           |
      |lourdes100@test.com| Test123!  | lourdestest | TestState | United States | This is all about me. |


  Scenario Outline: Add Phone Number

    Given the user is in the Newspaper Homepage
    And the user is logged-in "<username>" and "<password>" to Newspapers page
    When the user navigates to Account Info page
    And the user enters "<phoneNumber>" in Phone Number field
    And the user clicks the Save Changes button
    Then the Account Info success notification is displayed
    And the Phone Number field value is "<phoneNumber>"

      Examples:
      | username          | password  | phoneNumber  |
      |lourdes100@test.com| Test123!  | +1 4567891234|
