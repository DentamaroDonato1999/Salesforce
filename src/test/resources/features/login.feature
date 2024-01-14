@login
Feature: Authentication

  Scenario: Login
    Given I am on the login page
    When I Login as STANDARD user with the correct credentials
    Then I am on the Home Page



