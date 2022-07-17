package test_example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Test02_Example {
    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. Enter product name in search input and click search button
            7. Verify 'SEARCHED PRODUCTS' is visible
            8. Verify all the products related to search are visible

     */

    static WebDriver driver;
    @BeforeTest
    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterTest
    public static void quit(){
        driver.quit();
    }


    @Test(priority = 1)
    public void goToUrl(){
        driver.get("http://automationexercise.com");
        WebElement homePageTest = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePageTest.isDisplayed(),"Home Page Is Not Displayed!");

    }


    @Test(priority = 2)
    public void clickProductButton(){
        WebElement clickProductButton = driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        clickProductButton.click();
        WebElement productPageTest = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPageTest.isDisplayed(), "Product Page Is Not Displayed!");

    }

    @Test(priority = 3)
    public void productNameInSearchAndClickButton(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchBox.sendKeys("Winter Top");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

    }

    @Test(priority = 4)
    public void test(){
        WebElement searchedProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchedProduct.isDisplayed(), "Searched Product Is Not Displayed");
    }














}
