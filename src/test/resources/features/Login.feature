Feature: Testing Login user Reqres API

  @Task
  Scenario: Post login new user with valid json
    Given Post login user with valid json
    When Send login post register
    Then Should return status code 200
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate json schema login


    #negative case
  @Task
  Scenario: Post login new user with invalid json
    Given Post login user with invalid json
    When Send login post register
    Then Should return status code 200
