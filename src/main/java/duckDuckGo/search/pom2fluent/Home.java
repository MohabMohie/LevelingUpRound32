package duckDuckGo.search.pom2fluent;

import duckDuckGo.search.pom2fluent.Results;
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

    public Home open() {
        driver.navigate().to(url);
        return this;
    }

    public Results search(String searchQuery) {
        driver.findElement(searchInput).sendKeys(searchQuery, Keys.ENTER);
        return new Results(driver);
    }

//    public Home open() {
//        driver.navigate().to(url);
//        return this;
//    }
//
//    public Results search(String searchText) {
//        driver.findElement(searchInput).sendKeys(searchText, Keys.ENTER);
//        return new Results(driver);
//    }
}
