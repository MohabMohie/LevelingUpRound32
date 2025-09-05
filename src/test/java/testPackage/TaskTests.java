package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://www.selenium.dev/">selenium.dev/</a>]
     * Assert that the page header is "Selenium automates browsers. That's it!"
     */
    @Test
    public void checkPageTitleIsAdExpected(){
        driver.get("https://www.selenium.dev/");

        By headerLocator = By.tagName("h1");
        String actualHeader = driver.findElement(headerLocator).getText();
        String expectedHeader = "Selenium automates browsers. That's it!";

        Assert.assertEquals(actualHeader, expectedHeader, "Header text mismatch!");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://www.selenium.dev/selenium/web/web-form.html">selenium.dev/selenium/web/web-form.html</a>]
     * Read the value from the Readonly input field
     * Assert that the value is "Readonly input"
     */
    @Test
    public void readValueFromReadOnlyInput(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        By readOnlyInputLocator = By.name("my-readonly");
//        By.cssSelector("[name='my-readonly']");
//        By.xpath("//*[@name='my-readonly']");
        String actualValue = "";

//        actualValue = driver.findElement(readOnlyInputLocator).getText();
        actualValue = driver.findElement(readOnlyInputLocator).getDomAttribute("value");
//        actualValue = driver.findElement(readOnlyInputLocator).getDomProperty("value");
//        actualValue = driver.findElement(readOnlyInputLocator).getAttribute("value");

        String expectedValue = "Readonly input";

        Assert.assertEquals(actualValue, expectedValue, "Readonly input value mismatch!");
    }

    @Test
    public void typeIntoCustomListAndCheckTextWasTypedCorrectly(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        By customListLocator = By.name("my-datalist");
        String expectedTypedText = "Seattle";
        driver.findElement(customListLocator).sendKeys(expectedTypedText);

        String actualTypedText = driver.findElement(customListLocator).getDomProperty("value");

        Assert.assertEquals(actualTypedText, expectedTypedText, "Typed text mismatch!");
    }

    @Test
    public void typeIntoHiddenInput() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        By revealButtonLocator = By.id("reveal");
        driver.findElement(revealButtonLocator).click();

        // الدرك الاسفل لجحيم الاوتوميشن
        // r-click copy xpath
        // thread.sleep

//        Thread.sleep(1000); // Not recommended, use explicit waits instead
        By hiddenInputLocator = By.id("revealed");
        // implicit waits
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // explicit waits
        // wait until the hiddenInputLocator element is clickable, visible, present
        Wait<WebDriver> wait;

//        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait
//        //        wait.until(ExpectedConditions.visibilityOfElementLocated(hiddenInputLocator))
////                .sendKeys("expectedTypedText");
//        wait.until(d -> {
//            WebElement element = d.findElement(hiddenInputLocator);
//            return element.isDisplayed();
//        });
//        driver.findElement(hiddenInputLocator).sendKeys("expectedTypedText");

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
        ; // custom explicit wait

        wait.until(d -> {
            d.findElement(hiddenInputLocator).sendKeys("expectedTypedText");
            return true;
        });

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        //TODO: show th other way to set the implicit wait (challenge)
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
