package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

     /*
     1- Amazon Sayfasina girelim
     2- Url'nin amazon içerdiğini test edelim
     3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
     4- title'in BestBuy içerdiğini test edelim
     5- İlk sayfaya dönüp sayfada java aratalım
     6- Arama sonuclarının java içerdiğini test edelim
     7- Yeniden bestbuy sayfasına gidelim
     8- Logonun görünürlüğünü test edelim
     9- Sayfaları Kapatalım
     */

    WebDriver driver;
    /*
    Bize verilen task'te sayfalar arasinda gecis varsa her driver.get() method'undan sonra driver'in WindowHandle
    degerini String bir degiskene atariz.
    Sonrasinda farkli bir sayfaya ya da sekmeye gittikten sora tekrar ilk sayfaya donmemiz istenirse String degiskene
    atadigimiz WindowHandle degerleriyle sayfalar arasi gecis yapabiliriz.
     */

    @Test
    public void test01() {

        // Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWHandle = driver.getWindowHandle();


        // Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        // Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acmak icin bu method'u kullaniriz.
        driver.get("https://www.bestbuy.com");
        String bestBuyWHandle = driver.getWindowHandle();


        // title'in BestBuy içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "BestBuy";
        Assert.assertFalse(actualTitle.contains(expectedTitle));


        // İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);


        // Arama sonuclarının java içerdiğini test edelim
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc = sonuc.getText();
        Assert.assertTrue(actualSonuc.contains("java"));


        // Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWHandle);


        // Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}
