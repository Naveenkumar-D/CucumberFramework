@sanity @regression
Feature: Login Feature

  #Scenario: Successful Login valid credentials
    #Given the user navigate to login page
    #When the use enters email as "pavanoltraining@gmail.com" and password as "test@123"
    #And the user click on lofin button
    #Then the user should be redirect to the my account page
    #And the user get the title of the myaccount page

  Scenario Outline: Successful Login valid credentials
    Given the user navigate to login page
    When the use enters email as "<username>" and password as "<password>"
    And the user click on lofin button
    Then the user should be redirect to the my account page
    And the user get the title of the myaccount page

    Examples: 
      | username                  | password |
      | pavanoltest123@gmail.com  | test@123 |
      | pavanoltraining@gmail.com | test@123 |
