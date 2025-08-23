package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void testMethod() {
        System.out.println("Test method executed");

        WebDriver driver;
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.quit();

        WebDriver driver2 = new ChromeDriver();
        driver2.quit();

        new ChromeDriver().quit();
    }
}
