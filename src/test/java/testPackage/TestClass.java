package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void testMethod() {
        System.out.println("Test method executed");

        WebDriver driver;  //13 methods - cross-browser
//        RemoteWebDriver driver; //45 methods - cross-browser
//        ChromiumDriver driver; //x methods - Chromium-based browsers
//        ChromeDriver driver; //x methods - Chrome browser
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");

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
