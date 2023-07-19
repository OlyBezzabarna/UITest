Feature: Main Page

  Scenario: Fill and submit form
    Given I am on the main page
//   When I enter "my test!" in the text input
    And I enter "myNotCorrectPassword" in the password input
    And I clear the fields
    And I enter "Next step!" in the text input
    And I enter "My valid Password" in the password input
    And I submit the form
    Then I should see "Form submitted" as the header text
    Then after test