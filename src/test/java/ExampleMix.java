import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ExampleMix {
    public static void main(String[] args) {
        ////body[@class='gender-popup-lock']
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.trendyol.com/");
        //accept çerezz
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();


        //login button
        driver.findElement(By.xpath("p[@class='link-text']"));

        driver.findElement(By.xpath("//div[@class='login-button']")).click();


        //username
        WebElement userName = driver.findElement(By.xpath("//input[@id='login-email']"));
        userName.sendKeys("damla.45gencer@gmail.com");

        //password
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password-input']"));
        password.sendKeys("damlagencer1907");

        //username and password button for sign in
        driver.findElement(By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']")).click();

        WebElement searchBoxType = driver.findElement(By.className("search-box"));
        searchBoxType.sendKeys("İphone 13");
        searchBoxType.submit();






















    }
}
