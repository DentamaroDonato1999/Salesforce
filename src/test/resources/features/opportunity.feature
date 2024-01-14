@opportunity
Feature: Opportunità

  Background:
    Given I am logged as STANDARD user
    And I opened the application 'Sales Italia'

  Scenario: Opportunità Standard
    When I open 'Account'
    Then Account page is displayed