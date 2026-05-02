Feature: Verify ACME bank login page

  Scenario: Validate ACME bank login page with valid userid and password 
    Given valid url ACME login page
    And user is on ACME login page
    When user enters userid and password
    And click sign in button
    Then user is navigated to ACME home page