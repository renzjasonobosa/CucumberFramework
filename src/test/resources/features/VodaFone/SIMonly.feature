Feature: Vodafone Sim Only Page Validation

  Scenario Outline: Verify Add to cart button
1
    Given the user is in the VodafoneAustralia Sim Only Page
    When the user execute "<API>" request
    When the user checks the add to cart button label of plan <PLAN> in the UI
    Then the add to cart button text of plan <PLAN> in the UI matches with the ctaLabel field in the API response

    Examples:
      |API                                                                                     | PLAN                   |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New| SIM Only Lite Plan     |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New| SIM Only Lite+ Plan    |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New| SIM Only Super Plan    |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New| SIM Only Super+ Plan   |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New| SIM Only Ultra+ Plan   |


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

  Scenario Outline: Verify that the cart page shows the correct product after the user proceeds to cart

    Given the user is in the VodafoneAustralia Sim Only Page
    When clicks the add to cart button of the "<PLAN>"
    And the user clicks the continue to cart button in the sticky cart
    Then the user should be redirected to cart page
    And the added product should be <PLAN> with the price of <PRICE>

    Examples:
      |PLAN    |PRICE    |
      |SIM Only Lite Plan     | $40 |
      |SIM Only Lite+ Plan    | $45 |
      |SIM Only Super Plan    | $55 |
      |SIM Only Super+ Plan   | $65 |
      |SIM Only Ultra+ Plan   | $65 |

