package duckDuckGo.search.pom1standard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
    private final WebDriver driver;
    private static final String url = "https://duckduckgo.com/";
    private static final By searchInput = By.cssSelector("#searchbox_input");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void search(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText, Keys.ENTER);
    }
}
