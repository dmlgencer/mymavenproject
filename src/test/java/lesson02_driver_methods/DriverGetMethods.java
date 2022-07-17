package lesson02_driver_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //1) driver.get("url") --> method use go to what you want to url (istediğin url'ye gider)
        driver.get("https://www.amazon.com");//https mutlaka yazmalısın

        //2) driver.getTitle() --> içinde olduğu sayfanın başlığını döndürür
        System.out.println("sayfa title: " + driver.getTitle());//Amazon.com.Spend less. Smile more."

        //3) driver.getCurrentUrl() --> içinde olduğu sayfanın URL'ini döndürür.
        System.out.println(driver.getCurrentUrl());//https://www.amazon.com/

        //4) driver.getPageSource(); --> içinde olduğu sayfanın kaynak kodlarını döndürür
        //sayfanın kaynak kodlarında falnca kelimenin geçtiğini test edin derlerse bu kodu kullanabilirsin.
        System.out.println("===================================================");
        System.out.println(driver.getPageSource());// arka planda çalışan sayfa kodlarını yazdırır.
                                                    //sana String olrak döndürür.
        System.out.println("===================================================");

        //5) driver.getWindowHandle() --> içinde olduğu sayfanın UNIQUE hash kodunu dndürür.
        System.out.println(driver.getWindowHandle());//CDwindow-DBFDF8D8332689006BF8A3C700AC0067
                                                     //her çalıştırğında farklı sayılar gelecek.

        //6) driver.getWindowHandles() --> driver çalışırken açılan tüm sayfaların UNIQUE hash kodunu döndürür.







    }
}

