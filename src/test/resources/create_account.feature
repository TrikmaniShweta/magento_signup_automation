Feature: Create Account on Magento

  Background:
    Given the user is on the Magento home page
    When the user clicks on create account button
    Then user navigated to account creation page

  Scenario: User creates an account successfully
    Given the user enters valid details
    When the user submits the form
    Then the user should see a confirmation message

  Scenario Outline: User enters invalid email
    Given the user enters invalid "<Email>" and other details
    When the user submits the form
    Then the user should see an error message
    Examples:
      | Email                   |
      | shweta.thakkar          |
      | shweta.thakkar@abc!.com |
      | shweta.thakkar@abc      |
      | shweta                  |

  Scenario: User leaves all fields empty
    Given all mandatory fields are empty
    When the user submits the form
    Then validation message should appear for all mandatory fields

  Scenario: User enters partial fields
    Given the user enters valid firstname, lastname and email: "shweta","thakkar","shweta.thakkar@ab.com"
    When the user submits the form
    Then validation message should appear for empty fields

  Scenario: User enters an already registered email address
    Given the user enters valid firstname, lastname and email: "shweta","thakkar","shweta.thakkar@abcd.com"
    When the user enters a password: "Shweta@123"
    And the user enters a confirmation password: "Shweta@123"
    And the user submits the form
    Then the user should see an email already registered error message

  Scenario: User enters mismatched passwords
    Given the user enters valid firstname, lastname and email: "shweta","thakkar","shweta.thakkar@ab.com"
    When the user enters a password: "Shweta@123"
    And the user enters a confirmation password: "Abcd@123"
    And the user submits the form
    Then password mismatch validation error should appear

  Scenario: User enters a password that is too short
    Given the user enters valid firstname, lastname and email: "shweta","thakkar","shweta.thakkar@ab.com"
    When the user enters a password: "Shweta"
    Then the user should see a password length error message

    # This scenario will fail because first name and last name should not have digits. this validation is not added in website
  Scenario: User enters invalid firstname and lastname
    Given the user enters invalid firstname, lastname and email: "5234","4567"
    When the user enters a password: "Shweta@123"
    And the user enters a confirmation password: "Shweta@123"
    And the user submits the form
    Then validation message should appear for firstname and lastname

  Scenario Outline: Validate strength of password by adding multiple passwords
    Given the user enters valid firstname, lastname and email: "shweta","thakkar","shweta.thakkar@abcd.com"
    When the user enters a password: "<password>"
    Then validate password: "<strength>"

    Examples:
      | password   | strength |
      | shweta12   | Weak     |
      | Shweta@1   | Medium   |
      | Shweta@926 | Strong   |
      | hfdkjfkf   | Weak     |



