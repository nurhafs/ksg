Feature: AddUser
  As a new user
  I want to sign in
  So that I can get authorized

  Scenario: Sign in with valid username and password (authorized)
    Given I set add user url and valid token
    When I send request post login with valid username and password
    Then I am signed in

  Scenario: Sign in with null username and password (authorized)
    Given I set add user url and valid token
    When I send request post login
    Then I get null error message

  Scenario: Sign in with username and invalid password (authorized)
    Given I set add user url and valid token
    When I send request post login with valid username and invalid password
    Then I get invalid error message

  Scenario: Sign in with existing username and password (authorized)
    Given I set add user url and valid token
    When I send request post login with existing username and password
    Then I get existed error message