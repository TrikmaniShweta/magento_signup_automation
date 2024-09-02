package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.TestBase;

public class homePage extends TestBase {
    By createAccountBtn = By.xpath("(//li[@class=\"authorization-link\"]//following::li)[1]");
    public void clickCreateAccountBtn() {
        driver.findElement(createAccountBtn).click();
    }

}
