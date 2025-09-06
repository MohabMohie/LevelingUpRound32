package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebDriverBot {
//    WebDriver driver;
    Wait<WebDriver> wait;

    public WebDriverBot(WebDriver driver)
    {
//        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class)
        ;
    }

    public void type(String text, By locator)
    {
        wait.until(d -> {
            d.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typed text: " + text);
    }

    public void navigateTo(String url) {
        wait.until(d -> {
            d.navigate().to(url);
            return true;
        });
        System.out.println("Navigated to: " + url);
    }

    public void click(By searchInput) {
        wait.until(d -> {
            d.findElement(searchInput).click();
            return true;
        });
        System.out.println("Clicked on: " + searchInput);
    }
}
