# created on 11.Feb.2024
# Sivakumar.T

@smokeFeature
Feature: feature to test login functionality
  @smoketest
  Scenario: Check login is successfull with valid credential
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigate to home page
