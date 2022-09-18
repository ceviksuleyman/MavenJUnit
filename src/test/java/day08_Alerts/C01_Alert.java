package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Alert {

    /*
    Alert => Kullaniciya bir tur bilgi verme veya belirli bir islemi gerceklestirme izni istemek icin ekran
    bildirimi goruntuleyen kucuk mesaj kutusudur.Uyari amaciyla da kullanilabilir.

    HTML alerts => Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert'tir ve ekstra bir isleme
    gerek yoktur.

    Jscript Alerts => inspect yapilamaz,ekstra isleme ihtiyac vardir.
     */
    /*
    Eger bu uyariya incele(mouse sag tik-inspect)  yapabiliyorsak bu tur alert'lere HTML allert denir
    ve istedigimiz locate'i alabiliriz.
    Ama gelen uyari kutusuna mudahale(sag tik-inspect) edemiyorsak bu tur alert'lere jscript aler denir.
    js alert'lere mudahale edebilmek icin ;
     => Tamam ya da ok icin driver.switchTo().alert().accept(). kullanilir
     => iptal icin driver.switchTo().alert().dismiss().
     => alert icindeki mesaji almak icin driver.switchTo().alert().getText() kullanilir.
     => alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanilir.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        //https://the-internet.herokuapp.com/javascript_alerts adresine git
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        // - Click for is Alert butonuna tiklayalim.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);


        // - Tikladiktan sonra cikan uyari mesajina(alert) tamam diyelim
        System.out.println(driver.switchTo().alert().getText()); // uyaridaki yaziyi almak icin !
        driver.switchTo().alert().accept();

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
