package pomTestsPackage.pom2fluent;

import duckDuckGo.search.pom2fluent.Home;
import duckDuckGo.search.pom2fluent.Results;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstModularTest {
    private WebDriver driver;

    /**
     * Navigate to duckduck go, search for selenium webdriver, and assert that the first search result url is correct
     */
    @Test
    public void searchSeleniumWebDriverAndCheckFirstResultUrl() {
        // test data
        var searchQuery = "selenium webdriver";
        String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";

        // action chain
        String actualUrl =
                new Home(driver)
                .open()
                .search(searchQuery)
                .getSearchResultUrl(1);

        // checkpoint
        Assert.assertEquals(actualUrl, expectedUrl, "First search result URL does not match expected URL");
    }

    /**
     * Navigate to duckduck go, search for cucumberio, and assert that the second search result url is correct
     */
    @Test
    public void searchCucumberIoAndCheckSecondResultUrl() {
        var searchQuery = "cucumberio";
        String expectedUrl = "https://cucumber.io/";

        String actualUrl =
                new Results(driver)
                .open(searchQuery)
                .getSearchResultText(3);

        Assert.assertEquals(actualUrl, expectedUrl, "Second search result URL does not match expected URL");
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
