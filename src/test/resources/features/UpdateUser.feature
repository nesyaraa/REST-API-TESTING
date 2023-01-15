Feature: Testing Update user Reqres API
  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Nesa" and job "QA"

  @Task
  Scenario Outline: Put update user with invalid json
    Given Put update user with invalid json with id 54776
    When Send request put update user
    Then Should return status code 400
