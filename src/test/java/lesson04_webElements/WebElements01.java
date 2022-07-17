package lesson04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements01 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https:www.amazon.com sayfasına gidin.
        driver.get("https://www.amazon.com");

        //2- arama çubuğuna "nutella" yazdırın
        //öncelikle arama çubunu locate etmemiz gerekiyor.
        WebElement searchBox =  driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");
        //3- Nutella yazdıktan sonra ENTER'a basarak arama işlemi yapın
        searchBox.submit();
        //4- Bulunan sonuç sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //web elementleri direkt yazdırılamaz çünkü objedirler.
        System.out.println(result.getText());
        driver.close();












    }
}
