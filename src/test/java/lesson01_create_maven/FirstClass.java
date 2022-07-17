package lesson01_create_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //1) driver.get("url") --> method use go to what you want to url (istediğin url'ye gider)
        driver.get("https://www.amazon.com");//https mutlaka yazmalısın

        //2) driver.getTitle() --> içinde olduğu sayfanın başlığını döndürür
        System.out.println("sayfa title: " + driver.getTitle());//Amazon.com.Spend less. Smile more."

        //3) driver.getCurrentUrl() --> içinde olduğu sayfanın URL'ini döndürür.
        System.out.println(driver.getCurrentUrl());//https://www.amazon.com/









    }

}
