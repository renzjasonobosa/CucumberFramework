Feature: Newspapers.com Login Validation

  Scenario Outline: Verify Add to cart button

    Given the user is in the VodafoneAustralia Sim Only Page
    When the user execute "<API>" request
    And the user checks the add to cart button label
    Then the cta add to cart button in the UI matches with the ctaLabel field

    Examples:
      |API    |
      |https://api-prod.prod.cms.df.services.vodafone.com.au/plan/postpaid-simo?serviceType=New|
