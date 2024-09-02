package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import pages.homePage;
import testBase.TestBase;

import static org.junit.Assert.assertTrue;

public class HomePageSteps extends TestBase {
    private homePage homePage = new homePage();
    private String magentoTestUrl = "https://magento.softwaretestingboard.com";

    @Given("the user is on the Magento home page")
    public void the_user_is_on_the_home_page() {
        initialization();
        driver.get(magentoTestUrl);
    }

    @When("the user clicks on create account button")
    public void the_user_clicks_on_create_account_btn() {
        homePage.clickCreateAccountBtn();
    }

    @Then("user navigated to account creation page")
    public void user_navigated_to_account_creation_page() {
        assertTrue(driver.getCurrentUrl().contains("/customer/account/create"));
    }

}
