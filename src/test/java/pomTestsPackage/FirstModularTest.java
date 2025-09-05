package pomTestsPackage;

import duckDuckGo.search.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class FirstModularTest {
    private WebDriver driver;
    private Home home;

    /**
     * Navigate to duckduck go, search for selenium webdriver, and assert that the first search result url is correct
     */
    @Test
    public void testDuckDuckGoSearch() {
//        driver.navigate().to("https://duckduckgo.com/");
        home.open();

        var keysToSend = "selenium webdriver";
//        driver.findElement(searchInput).sendKeys(searchText, Keys.ENTER);
        home.search(keysToSend);

//        driver.navigate().to("https://duckduckgo.com/?t=h_&q=selenium+webdriver&ia=web");

        By firstSearchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[1]");
        String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
        String actualUrl = driver.findElement(firstSearchResultUrl).getDomAttribute("href");

        Assert.assertEquals(actualUrl, expectedUrl, "First search result URL does not match expected URL");
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        driver
//                = new ChromeDriver();
            = new ChromeDriver(options);

        home = new Home(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
