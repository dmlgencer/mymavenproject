package lesson05_framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_After_Before_Notation {

    // Olusturdugumuz test class'inin icindeki test method'lari
    // hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    // ve her method icin bu driver'i kapatmaya gerek yoktur
    // Class'in basinda bir kere setup calisip, en sonda kapansa olur
    // dersek BeforeClass ve AfterClass kullaniriz
    /*
        1) After, AfterClass, Before, BeforeClass are must be "static".

        2) "@Ignore" notasyonu o testi görmezden gel demektir. Neden bir testi görmezden geliriz?
                                                               - Üzerinde değişiklik yapıyoruzdur.
                                                               - Aksayan bir şey vardır.

     */





     static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        //Normalde WebDriver driver = new ChromeDriver(); şeklinde tanımlıyorduk. Ancak setUp() methodunun içinde tanımlarsan diğer methodların içinde kullanamazsın
        //Bu yüzden classın içinde setUp() methodunun dışında tanımladık ve static yaptık çünkü methodların dışında classın içinde bir variable tanımlarsak
        //diğer methodların içinde kullanabilmemiz için "satatic" olmak zorunda.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01() {
        // amazon ana sayfaya gidelim
        driver.get("https:www.amazon.com");
    }

    @Test @Ignore
    public void test02() {
        // title yazdiralim
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03() {
        // url yazdiralim
        System.out.println(driver.getCurrentUrl());
    }

}
