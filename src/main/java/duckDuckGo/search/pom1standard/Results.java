package duckDuckGo.search.pom1standard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    // variables
    private final WebDriver driver;

    // locators
//    private static final By firstSearchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[1]");
//    private static final By secondSearchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[2]");
    private By searchResultUrl = null; // By.xpath("(//a[@data-testid='result-title-a'])[1]");

    // constructor
    public Results(WebDriver driver) {
        this.driver = driver;
    }

    // actions
    public void open(String searchText){
        var updatedString = searchText.replace(" ", "+");
        driver.navigate().to("https://duckduckgo.com/?t=h_&q="+updatedString+"&ia=web");
    }

//    public String getFirstSearchResultUrl(){
//        return driver.findElement(firstSearchResultUrl).getDomAttribute("href");
//    }
//
//    public String getSecondSearchResultUrl() {
//        return driver.findElement(secondSearchResultUrl).getDomAttribute("href");
//    }

    public String getSearchResultUrl(int resultNumber) {
        searchResultUrl = By.xpath("(//a[@data-testid='result-title-a'])[" + resultNumber + "]");
        return driver.findElement(searchResultUrl).getDomAttribute("href");
    }
}
