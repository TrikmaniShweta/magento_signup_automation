package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;

    public static void initialization() {
        driver = new ChromeDriver();
    }

    public static void termination() {
        driver.quit();
    }
}
