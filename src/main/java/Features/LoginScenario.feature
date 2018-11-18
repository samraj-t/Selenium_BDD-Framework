Feature: Login To System
  Scenario: Login to the system with credentials

    Given I have user name and password

    When I successfully login 

    Then I should navigate to the home page