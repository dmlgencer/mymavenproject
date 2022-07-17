package lesson04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement02 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1) facebook.com a git
        driver.get("https://www.facebook.com");

        //2) cookies çıkarsa kabul et butonuna tıkla
   //     driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();


        //3) e-posta kutusuna rastgele bir mail gir
        WebElement eMail = driver.findElement(By.xpath("//input[@id='email']"));
        eMail.sendKeys("jhdwefwnfw");

        //4) şifre kısmına rastgele bir sifre gir
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("GHWKkcnekcn76*");

        //5) giriş yap butonuna bas
        driver.findElement(By.xpath("//button[@name='login']")).click();


        //6) uyarı olarak "The mail or mobile number you entered is not connected to an account. Find your account and log ." mesajının çıktığını teste edin
        WebElement uyari = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedResult = "The mail or mobile number you entered is not connected to an account. Find your account and log .";
        String actualResult = uyari.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Negative Test Passed");
        }else{
            System.out.println("Negative Test Failed");
        }


        //7) sayfayı kapatın
        driver.close();


    }
}
