package pomTestsPackage.pom3standardAbstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTests extends PaymentTestScenario
{
    @Test
    public void testFirstModularTest()
    {
        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.cssSelector("#searchbox_input")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.navigate().to("https://duckduckgo.com/?t=h_&q=selenium+webdriver&ia=web");
        String firstResultUrl = driver.findElement(By.xpath("(//a[@data-testid='result-title-a'])[1]")).getDomAttribute("href");
        Assert.assertEquals(firstResultUrl, "https://www.selenium.dev/documentation/webdriver/");
    }
}
