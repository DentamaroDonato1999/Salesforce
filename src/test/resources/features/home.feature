@home
Feature: Home Page

  Background:
    Given I am logged as STANDARD user
    And I am on the Home Page

  Scenario: Sales Italia
    When I select the application 'Sales Italia'
    Then  Application 'Sales Italia' is displayed