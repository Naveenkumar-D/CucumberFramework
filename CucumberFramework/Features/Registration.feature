Feature: Account Registration Feature

  Scenario: Successful resgistration
    Given the user navigate to register page
    When the user enter details into below fields
      | firstName | Jhon       |
      | lastName  | David      |
      | telephone | 1234567890 |
      | password  | test@123   |
    And the user select private policy
    And the user click on Continue
    Then the user account should get successfully
