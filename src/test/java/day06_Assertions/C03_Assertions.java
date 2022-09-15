package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
     */
    static WebDriver driver;

    @Test
    public void test01() {
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test02() {
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.cssSelector("yt-icon[id='logo-icon']")).isDisplayed());
    }

    @Test
    public void test03() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='search_query']")).isEnabled());
    }

    @Test
    public void test04() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(unexpectedTitle, actualTitle);
    }


    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
