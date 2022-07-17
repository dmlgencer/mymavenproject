package lesson04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElement03 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://www.bestbuy.com adresine git
        driver.get("https://www.bestbuy.com");


        //2- cookies çıkarsa kabu et butonuna bas

        //3- sayfada kaç adet buton bulunduğunu yazdırın
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        //4- sayfadaki her buton üzerindeki yazıları yazdırın
        for (WebElement w : buttonList) {
            System.out.println(w.getText());
        }
    }
}
