package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTests {

    private WebDriver driver;

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo.com</a>]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void firstTask() {
        driver.get("https://duckduckgo.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo.com</a>]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     */
    @Test
    public void secondTask() {
        driver.get("https://duckduckgo.com/");

        By logoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        boolean isLogoDisplayed = driver.findElement(logoLocator).isDisplayed();

//        driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img")).isDisplayed();
//
//        WebElement logo = driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img"));
//        logo.isDisplayed();

        Assert.assertTrue(isLogoDisplayed, "DuckDuckGo logo is not displayed!");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
