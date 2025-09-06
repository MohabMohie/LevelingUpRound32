package pomTestsPackage.pom1standard;

import duckDuckGo.search.pom1standard.Home;
import duckDuckGo.search.pom1standard.Results;
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
    private Home home;
    private Results results;

    /**
     * Navigate to duckduck go, search for selenium webdriver, and assert that the first search result url is correct
     */
    @Test
    public void searchSeleniumWebDriverAndCheckFirstResultUrl() {
        var searchQuery = "selenium webdriver";
        home.open();
        home.search(searchQuery);
        String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
        String actualUrl = results.getSearchResultUrl(1);
        Assert.assertEquals(actualUrl, expectedUrl, "First search result URL does not match expected URL");
    }

    /**
     * Navigate to duckduck go, search for cucumberio, and assert that the second search result url is correct
     */
    @Test
    public void searchCucumberIoAndCheckSecondResultUrl() {
        var searchQuery = "cucumberio";
        results.open(searchQuery);
        String expectedUrl = "https://cucumber.io/";
        String actualUrl = results.getSearchResultUrl(2);
        Assert.assertEquals(actualUrl, expectedUrl, "Second search result URL does not match expected URL");
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        driver
            = new ChromeDriver(options);

        home = new Home(driver);
        results = new Results(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
