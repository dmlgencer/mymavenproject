package lesson06_JUnit_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class C02_Test_With_AssertionMethods {
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");

        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        searchBox.submit();

        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualStr = result.getText();

        // 1-48 of 105 results for "Nutella"
        String expectedSearchWord = "Kutella";

        Assert.assertTrue(actualStr.contains(expectedSearchWord));

    }


}
