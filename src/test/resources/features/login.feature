@login
Feature: Search by keyword

  Scenario: Login
    Given I am on the login page
    When I Login as standard user with the correct credentials
      | username                                        | password         |
      | andrea.missinato@consulting-for.edenred.com.uat | !Password!202312 |
    Then I am on the Home Page



