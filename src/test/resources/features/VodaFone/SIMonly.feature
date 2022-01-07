Feature: Newspapers.com Login Validation

  Scenario Outline: Verify Add to cart button

    Given the user is in the VodafoneAustralia Sim Only Page
    When the user execute "<API>" request
    And the user checks the add to cart button label
    Then the cta add to cart button in the UI matches with the ctaLabel field

    Examples:
      |API    |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New|

  Scenario Outline: Verify price on sticky cart

    Given the user is in the VodafoneAustralia Sim Only Page
    When clicks the add to cart button of the "<PLAN>"
    Then the "<PRICE>" shown in the sticky cart is the same as the selected "<PLAN>"

    Examples:
      |PLAN    |PRICE    |
      |SIM Only Lite Plan     | $40 |
      |SIM Only Lite+ Plan    | $45 |
      |SIM Only Super Plan    | $55 |
      |SIM Only Super+ Plan   | $65 |
      |SIM Only Ultra+ Plan   | $65 |