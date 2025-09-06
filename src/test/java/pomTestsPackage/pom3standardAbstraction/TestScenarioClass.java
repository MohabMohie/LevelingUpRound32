package pomTestsPackage.pom3standardAbstraction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestScenarioClass {
    WebDriver driver;
    
    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        driver= new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
