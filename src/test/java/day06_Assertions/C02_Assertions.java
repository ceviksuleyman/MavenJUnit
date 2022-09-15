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

public class C02_Assertions {

    /*
   1) Bir class oluşturun: BestBuyAssertions
   2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
  */
    static WebDriver driver;


    @Test
    public void test01() {
        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";

        Assert.assertEquals(expectedUrl, actualUrl);
    }


    @Test
    public void test02() {

        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String unexpectedTitle = "Rest";

        Assert.assertFalse(actualTitle.contains(unexpectedTitle));
    }


    @Test
    public void test03() {

        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed());
    }

    @Test
    public void test04() {

        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin  button[lang='fr'] -- //*[@lang='fr']
        WebElement francaisLink = driver.findElement(By.cssSelector("button[lang='fr']"));
        Assert.assertTrue(francaisLink.isDisplayed());
    }


    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }


    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
