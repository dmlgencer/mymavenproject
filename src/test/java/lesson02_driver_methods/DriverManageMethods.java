package lesson02_driver_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- driver.manage().window() methods
        //a) - driver.manage().window().getSize(); --> içinde olduğu sayfanın pixel olarak ölçülerini döndürür.
        System.out.println(driver.manage().window().getSize());//(1051, 806) pixel
        System.out.println(driver.manage().window().getSize().height);//806

        //b) - driver.manage().window().getPosition() --> içinde olduğu sayfanın pixel olarak konumunu döndürür.
        System.out.println(driver.manage().window().getPosition());//(9, 9)

        //c) - driver.manage().window().setPosition(new Point(15,15)); --> içinde olduğu sayfanın sol alt köşesini bizim yazacağımız pixel noktasına taşır
        driver.manage().window().setPosition(new Point(15,15));

        //d) - driver.manage.window.setSize(new Dimension(900, 600)));
        //içinde olduğu sayfanın sol alt köşesi sabit olarak bizim yazacapımız ölçülere getirir.
        driver.manage().window().setSize(new Dimension(900, 600));

        //konumu ve boyutu yeniledikten sonra tekrar yazdırırsak.
        System.out.println("yeni pencere ölçüleri: " + driver.manage().window().getSize());// 900, 600
        System.out.println("yeni pencere konumu: " + driver.manage().window().getPosition());// 15, 15



        //e) - driver.manage().window().maximize(); --> içinde olduğu sayfayı maximize yapar.
        //g) - driver.manage().window().fullscreen(); --> içinde olduğu sayfayı fullscreen yapar

        //farklarını görmek için bu methodları kullanıp, başlandıç noktalarını ve boyutlarını yazdıralım
        driver.manage().window().maximize();
        System.out.println("maximize konum: " + driver.manage().window().getPosition());
        System.out.println("maximize boyut: " + driver.manage().window().getSize());


        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum: " + driver.manage().window().getPosition());
        System.out.println("fullscreen boyut: " + driver.manage().window().getSize());

        //f) driver.manage().window().minimize(); --> sayfayı simge durumunda küçültür.



        //2- driver.manage().timeouts() methods

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        /*
            wait konusunu ilerde tek başına ele alacağız
            ancak her class için yapmamız gereken ayar olduğu için burada kısca değinelim

            implicitlyWait() : driver a sayfanın yüklenmesi ve kullanacağımız webelementlerin bukunması için
                               bekleyeceği maximum süreyi belirtir.
                               driver bu süre içerisinde sayfa yüklenir/web element bulunursa beklemeden çalışmaya devam eder.
                               bu süre bittiği halde sayfa yüklenememiş/webelement bulunamamışsa exception vererek çalışmayı durdurur.

            Duration.ofSeconds(15) : Duration classı Selenium-4 ile gelen zaman classsıdır.
                                     Yani driver'a ne kadar bekleyeceğini söyler
                                     Duration.ofSeconds(15) yerine milis, minutes, minutes, hours da kullanılabilir.

         */

        /*
           Note: Driverin istediğimiz işlemleri yaparken sorunla karşılaşılmaması için driver.manage() methodlarından
           maximixe() ve implicitltWait() methodlarının her testte kullanılması faydalı olacaktır.
         */




























    }
}
