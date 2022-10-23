Feature: Generate Token
  As a user
  I want to generate token
  So that I can get authorized

  Scenario: Generate token with registered username and password
    Given I set generate token url with authorization
    When I send request post with registered username and password
    Then I get token

  Scenario: Generate token with unregistered username and password
    Given I set generate token url with authorization
    When I send request post with unregistered username and password
    Then I don't get token