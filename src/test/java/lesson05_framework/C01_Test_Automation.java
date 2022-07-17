package lesson05_framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class C01_Test_Automation {
    //şidiye kadar Java'da bir classin çalışması için main method sarttır dedik
    //@Test notasyonu ile bu mecburiyet bitti.
    //@Test notasyonu olmayan methodlar bugüne kadar yaptığımız gibi sadece çağırıldıklarında çalışır.
    //Ancak @Test eklendiğinde bağımsız çalışabilir hale gelir.


    @Test
    public void test01(){
        //ayarları yapalım
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https:www.amazon.com a git.
        driver.get("https:www.amazon.com");

        //2- arama çubuğuna "nutella" yazdır.
        WebElement searchBox =  driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");

        //3- Nutella yazdıktan sonra ENTER a basarak arama işlemi yapın
        searchBox.submit();

        //4- bulunan sonuç sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());

        driver.close();







    }







}
