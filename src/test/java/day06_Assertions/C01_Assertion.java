package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertion {

    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    - url'in "amazon" icergini test et
    - title'in "facebook" icermedigini test et
    - sol ust kosede amazon logosunun gorundugunu test et
    - Url'in "https://www.facebook.com" oldugunu test et
     */
    static WebDriver driver;

    @Test
    public void test01() {
        //- url'in "amazon" icergini test et
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test02() {
        //- title'in "facebook" icermedigini test et
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03() {
        //- sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04() {
        //Url'in "https://www.facebook.com" olmadigini test et
        String unexpectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(unexpectedUrl, actualUrl);
    }


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
