package duckDuckGo.search.pom2fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    // variables
    private final WebDriver driver;

    // locators
    private By searchResultUrl = null; // By.xpath("(//a[@data-testid='result-title-a'])[1]");
    private By searchResultText = null; // By.xpath("(//a[@data-testid='result-title-a'])[1]/following-sibling::div");

    // constructor
    public Results(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResultUrl(int i) {
        searchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[" + i + "]");
        return driver.findElement(searchResultUrl).getDomAttribute("href");
    }

    public Results open(String searchQuery) {
        var updatedString = searchQuery.replace(" ", "+");
        driver.navigate().to("https://duckduckgo.com/?t=h_&q=" + updatedString + "&ia=web");
        return this;
    }

    public String getSearchResultText(int resultNumber) {
        searchResultText = By.xpath("(//a[@data-testid='result-title-a'])[" + resultNumber + "]/following-sibling::div");
        return driver.findElement(searchResultText).getText();
    }

//    // actions
//    public Results open(String searchText){
//        var updatedString = searchText.replace(" ", "+");
//        driver.navigate().to("https://duckduckgo.com/?t=h_&q="+updatedString+"&ia=web");
//        return this;
//    }
//
//    public String getSearchResultUrl(int resultNumber) {
//        searchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[" + resultNumber + "]");
//        return driver.findElement(searchResultUrl).getDomAttribute("href");
//    }
}
