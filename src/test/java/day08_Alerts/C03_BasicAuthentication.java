package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    1 - Bir class olusturun : BasicAuthentication
    2 - https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3 - asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        Html komutu : https://username:password@URL
        Username : admin
        password : admin
    4 - Basarili sekilde sayfaya girildigini dogrulayin
     */
    WebDriver driver;
     /*
     NOTE => Authentication Nedir ?
     herhangi bir internet kullanicisinin, uygulamanin ya da  programin, soz konusu sisteme dahil olup olamayacagini
     belirleyen  formu ifade eder.
     */

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void test01() {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement home = driver.findElement(By.xpath("//*[@class='example']"));
        System.out.println(home.getText());
        Assert.assertTrue(home.isDisplayed());
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
