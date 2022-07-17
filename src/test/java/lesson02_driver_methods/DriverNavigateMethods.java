package lesson02_driver_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1- driver.navigate().to("url") --> istenen url'e gider.
        //   driver.get("url") ile aynı işlemi yapar ama forward ve back yapılmasına imkan tanır.
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.fazcebook.com");

        //2- driver.navigate().back(); --> bir önceki sayfaya dönüş yapar.
        driver.navigate().back();

        //3- driver.navigate().forward() --> back() ile girdiği sayfaya yeniden gider.
        driver.navigate().forward();

        //4- driver.navigate().refresh(); --> içinde olduğu sayfayı yeniler.
        driver.navigate().refresh();


        //driver olduşturduğunda açılan sayfayı kapatmak istersek
   //     driver.close();
        //ikisi birden çalışmaz
        //driver çalışırken birden fazla tab veya window açtıysa tümünü kapatmak için
        driver.quit();





    }
}






















