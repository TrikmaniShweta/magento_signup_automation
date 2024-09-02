package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TestBase;

import java.time.Duration;
import java.util.Random;

public class createAccountPage extends TestBase {
    By firstNameTxt = By.id("firstname");
    By lastNameTxt = By.id("lastname");
    By emailAddressTxt = By.id("email_address");
    By passwordTxt = By.id("password");
    By confirmPasswordTxt = By.id("password-confirmation");
    By emailAddressError = By.id("email_address-error");
    By submitButton = By.xpath("//button[@title=\"Create an Account\"]");
    By successMessage = By.cssSelector(".message-success");
    By firstNameError = By.id("firstname-error");
    By lastNameError = By.id("lastname-error");
    By passwordError = By.id("password-error");
    By confirmPasswordError = By.id("password-confirmation-error");
    By passwordStrength = By.id("password-strength-meter-label");
    By registeredEmailError = By.className("message-error");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        System.out.println("Entered Email Address: " + emailAddress);
        driver.findElement(emailAddressTxt).sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
    }

    public WebElement returnEmailAddressError() {
        return driver.findElement(emailAddressError);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public WebElement returnSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return driver.findElement(successMessage);
    }

    public WebElement returnFirstNameError() {
        return driver.findElement(firstNameError);
    }

    public int returnNumberOfFirstNameError() {
        return driver.findElements(firstNameError).size();
    }

    public int returnNumberOfLastNameError() {
        return driver.findElements(lastNameError).size();
    }

    public WebElement returnLastNameError() {
        return driver.findElement(lastNameError);
    }

    public WebElement returnPasswordError() {
        return driver.findElement(passwordError);
    }

    public WebElement returnConfirmPasswordError() {
        return driver.findElement(confirmPasswordError);
    }

    public WebElement returnPasswordStrengthError() {
        return driver.findElement(passwordStrength);
    }

    public WebElement returnRegisteredEmailError(){
        wait.until(ExpectedConditions.elementToBeClickable(registeredEmailError));
        return driver.findElement(registeredEmailError);
    }

    public static String randomStringSimple(int length) {
        String alphabeticCharacters = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer randomString = new StringBuffer(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(alphabeticCharacters.length());
            char randomChar = alphabeticCharacters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

}
