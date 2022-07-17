package test_example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
public class Test01_Example {
    /*
            Test Steps                                                              Assertions
            1) Go to Amazon Home Page                                               1) Are we on Home Page?
            2) Search for a product in search box                                   2) Are we on Product Page?
            3) Click a product                                                      3) Are we on Product Detail Page?
            4) Add product to Cart                                                  4) Check product count on cart image on Home Page?
            5) Go to Cart Page                                                      5) Check if the product was added to cart successfully
     */
    static WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void homePage(){
        driver.get("https://www.amazon.com/");
        WebElement homePageTest = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base']"));
        Assert.assertTrue(homePageTest.isDisplayed(), " Home Page Is Not Displayed!");


    }
    @Test(priority = 2)
    public void searchProduct(){
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Huawei");
        searchBox.submit();
        WebElement searchSomethingTest = driver.findElement(By.xpath("//span[text()='1-16 of 238 results for']"));
        Assert.assertTrue(searchSomethingTest.isDisplayed(), "Not Displayed!");

    }

    @Test(priority = 3)
    public void clickProduct(){
        WebElement clickProduct = driver.findElement(By.xpath("//span[text()='Huawei Mate 10 Porsche Design Factory Unlocked 256GB Android Smartphone Diamond Black']"));
        clickProduct.click();
        WebElement productDetailPage = driver.findElement(By.xpath("//span[@id='productTitle']"));
        Assert.assertTrue(productDetailPage.isDisplayed(), "Product Detail Page Is Not Displayed!");

    }

    @Test(priority = 4)
    public void addProductToCart(){
        WebElement addProductToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addProductToCart.click();
        WebElement addCartTest =  driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(addCartTest.isDisplayed(), "Product Is Not Displayed");

    }










}
