Feature: Newspapers.com User Dashboard Validation

  Scenario Outline: Verify Newspapers User Dashboard contents

    Given the user is in the Newspaper Homepage
    And the user is logged-in "<username>" and "<password>" to Newspapers page
    When the user is on Newspaper Dashboard page
    Then the search module is displayed
    And the About article content is "<aboutContent>"
    And the Explore All Titles button is displayed
    And the Explore All Locations button is displayed

      Examples:
      | username          | password  | aboutContent |
      |lourdes100@test.com| Test123!  | The largest online newspaper archive, established in 2012. Used by millions for genealogy and family history, historical research, crime investigations, journalism, and entertainment. Search for obituaries, marriage announcements, birth announcements, social pages, national and local news articles, sports, advertisements, entertainment, fashion and lifestyle pages, comics, and more. Everything you’d expect in the paper—and maybe something you didn't! |


