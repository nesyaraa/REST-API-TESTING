Feature: Testing Reqres API AlTA QE8
  @Latihan
  Scenario Outline: Get list users with valid parameter page reqres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body should page should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  @Task
  Scenario Outline: Get list users with invalid parameter page reqres API
    Given Get list user with invalid page 15
    When Send request get list user
    Then Should return status code 400






