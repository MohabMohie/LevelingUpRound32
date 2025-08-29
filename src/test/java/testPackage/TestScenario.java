package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestScenario {
    private WebDriver driver;


    @Test
    public void loginTest() {
        // Code to test login functionality
        System.out.println("Login test executed");
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void addItemToCartTest() {
        // Code to test adding an item to the cart
        System.out.println("Add item to cart test executed");
    }

    @Test(dependsOnMethods = {"loginTest", "addItemToCartTest"})
    public void checkoutTest() {
        // Code to test the checkout process
        System.out.println("Checkout test executed");
    }

    @Test(dependsOnMethods = {"loginTest", "addItemToCartTest", "checkoutTest"})
    public void orderCompletedTest(){
        // Code to test order completion
        System.out.println("Order completed test executed");
    }

//    @Test
//    public void e2eScenario(){
//        // Code to test login functionality
//        //        Assert.
//        // Code to test adding an item to the cart
//        //        Assert.
//        // Code to test the checkout process
//        //        Assert.
//        // Code to test order completion
//        //        Assert.
//    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
