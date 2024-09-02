package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.createAccountPage;
import testBase.TestBase;

import static org.junit.Assert.*;

public class CreateAccountSteps extends TestBase {
    private createAccountPage signupPage = new createAccountPage();

    @Given("the user enters valid details")
    public void the_user_enters_valid_details() {
        signupPage.enterFirstName("Shweta");
        signupPage.enterLastName("Thakkar");
        signupPage.enterEmailAddress("shweta.thakkar@" + signupPage.randomStringSimple(5) + ".com");
        signupPage.enterPassword("Password123");
        signupPage.enterConfirmPassword("Password123");
    }

    @Given("the user enters invalid {string} and other details")
    public void the_user_enters_invalid_email_and_other_details(String invalidEmail) {
        System.out.println("Invalid input email - " + invalidEmail);
        signupPage.enterFirstName("Shweta");
        signupPage.enterLastName("Thakkar");
        signupPage.enterEmailAddress(invalidEmail);
        signupPage.enterPassword("Password123");
        signupPage.enterConfirmPassword("Password123");
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        signupPage.clickSubmitButton();
    }

    @Then("the user should see a confirmation message")
    public void the_user_should_see_a_confirmation_message(){
        WebElement confirmationMessage = signupPage.returnSuccessMessage();
        assertTrue(confirmationMessage.isDisplayed());
        System.out.println("Validation message for signup success confirmation");
        termination();
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        WebElement errorMessage = signupPage.returnEmailAddressError();
        assertTrue(errorMessage.isDisplayed());
        System.out.println("Invalid Email Address");
        termination();
    }

    @Given("all mandatory fields are empty")
    public void all_mandatory_fields_empty() {

    }

    @Then("validation message should appear for all mandatory fields")
    public void validation_message_for_all_mandatory_fields() {

        assertTrue(signupPage.returnFirstNameError().isDisplayed());
        assertTrue(signupPage.returnLastNameError().isDisplayed());
        assertTrue(signupPage.returnEmailAddressError().isDisplayed());
        assertTrue(signupPage.returnPasswordError().isDisplayed());
        assertTrue(signupPage.returnConfirmPasswordError().isDisplayed());
        System.out.println("All validation message are present.");
        termination();
    }

    @Then("validation message should appear for empty fields")
    public void validation_message_for_empty_fields() {
        assertTrue(signupPage.returnNumberOfFirstNameError() == 0);
        assertTrue(signupPage.returnPasswordError().isDisplayed());
        assertTrue(signupPage.returnConfirmPasswordError().isDisplayed());
        System.out.println("All validation message for empty fields.");
        termination();

    }


    @Given("the user enters valid firstname, lastname and email: {string},{string},{string}")
    public void enter_firstname_lastname_email(String firstName, String lastName, String email) {
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
        signupPage.enterEmailAddress(email);
    }

    @Given("the user enters invalid firstname, lastname and email: {string},{string}")
    public void enter_invalid_firstname_lastname_email(String firstName, String lastName) {
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
        signupPage.enterEmailAddress(signupPage.randomStringSimple(5));
    }

    @When("the user enters a password: {string}")
    public void enter_password(String password) {
        signupPage.enterPassword(password);
    }

    @And("the user enters a confirmation password: {string}")
    public void enter_wrong_confirmation_password(String confirmationPassword) {
        signupPage.enterConfirmPassword(confirmationPassword);
    }

    @Then("password mismatch validation error should appear")
    public void password_mismatch_validation() {
        assertTrue(signupPage.returnConfirmPasswordError().getText().equals("Please enter the same value again."));
        System.out.println("Validation of Password Mismatch.");
        termination();
    }

    @Then("the user should see a password length error message")
    public void short_password_validation() {
        assertTrue(signupPage.returnPasswordError().getText().contains("Minimum length of this field must be equal or greater than 8 symbols."));
        System.out.println("Validation of Password Length.");
        termination();

    }

    @Then("the user should see an email already registered error message")
    public void registered_email_validation() {
        assertTrue(signupPage.returnRegisteredEmailError().getText().contains("There is already an account with this email address."));
        System.out.println("Validation of Existing Email.");
        termination();

    }

    @Then("validation message should appear for firstname and lastname")
    public void validation_for_firstname_and_lastname() {
        assertTrue(signupPage.returnNumberOfFirstNameError() > 0);
        assertTrue(signupPage.returnNumberOfLastNameError() > 0);
        System.out.println("Validation of FirstName and LastName.");
        termination();
    }

    @Then("validate password: {string}")
    public void validate_password_strength(String strength) {
        signupPage.returnPasswordStrengthError().getText().contains(strength);
        System.out.println("Validation of Password Strength.");
        termination();
    }

}
