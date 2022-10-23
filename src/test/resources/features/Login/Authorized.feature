Feature: Authorized
  As a new user
  I want to get authorized
  So that I can access the webpage

  Scenario: Sign in with valid username and password
    Given I set authorization url
    When I send request post with valid username and password
    Then My username and password is authorized

  Scenario: Sign in with invalid username and password
    Given I set authorization url
    When I send request post with invalid username and password
    Then I get error code 404
