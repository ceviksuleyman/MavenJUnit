package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    /*
     BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagimiz method'u static yapmak gereklidir.
    */
    static WebDriver driver;

    /*
    befero afterda her test icin farkli browser acip kapatiyor
    beforeClass AfterClass'ta ise tek browser'dan testleri acip kapatiyor
     */
    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }


    @Test
    @Ignore // calismasini istemedigimiz test icin @Ignore notasyonu kullanilir.
    public void method1() {

        driver.get("https://www.amazon.com");
    }

    @Test
    public void method2() {

        driver.get("https://www.incehesap.com");
    }

    @Test
    public void method3() {

        driver.get("https://www.youtube.com");
    }

}
