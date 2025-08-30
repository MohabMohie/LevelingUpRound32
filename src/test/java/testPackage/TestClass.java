package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    @Test
    public void testMethod() {
        System.out.println("Test method executed");

        WebDriver driver;  //13 methods - cross-browser
//        RemoteWebDriver driver; //45 methods - cross-browser
//        ChromiumDriver driver; //x methods - Chromium-based browsers
//        ChromeDriver driver; //x methods - Chrome browser
        driver = new ChromeDriver();

        driver.quit();
        driver.close();

        driver.get("https://www.google.com");
        driver.navigate().to("https://duckduckgo.com/?t=h_&q=selenium+webdriver&ia=web");

        WebElement element = driver.findElement(By.xpath(""));
//        return driver.findElements(By.xpath("spinner")).size() == 0;

        String title = driver.getTitle();
        driver.getCurrentUrl();
        driver.getPageSource();

        driver.manage().logs();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.manage().window().setSize(new Dimension(720, 480)); //720p
        driver.manage().window().setPosition(new Point(0,0));
        driver.switchTo();
        driver.navigate();

        element.isDisplayed(); // style="display:none;"
        element.isEnabled(); // disabled
        element.isSelected(); // checked, selected

        element.getText();
        element.getDomAttribute("");
        element.getDomProperty("");
        element.getAttribute("");

        element.getCssValue("border-bottom-color");
        element.getAriaRole();
        element.getAccessibleName();

        element.click();
        element.sendKeys("Selenium", " ", "WebDriver");
        element.clear();

        element.sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.ENTER, Keys.TAB, Keys.ENTER);

        element.sendKeys("""
                // navigate to duckduckgo\n\r
                       // search for selenium webdriver
                       // check result for first link""");

        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "x"), "");

        // navigate to duckduckgo
        // search for selenium webdriver
        // check result for first link

//        System.out.println(driver);
        driver.quit();
//
//        WebDriver driver2 = new ChromeDriver();
//        driver2.quit();
//
//        new ChromeDriver().quit();

//        WebDriver driver;
    }
}
