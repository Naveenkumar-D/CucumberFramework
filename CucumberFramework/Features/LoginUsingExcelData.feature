Feature: LoginUsingExcelData Feature

  Scenario Outline: Successful Login sing excel data
    Given the user navigate to login page
    When the user navigates to my account page by passing email and passwordwith excel row "<rows>"

    Examples: 
      | rows |
      |    1 |
      |    2 |
      |    3 |
      |    4 |
      |    5 |
     
     