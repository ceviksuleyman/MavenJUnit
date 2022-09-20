package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task01 {
     /*
    ● Bir class olusturun: IframeTest02
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    2) sayfadaki iframe sayısını bulunuz.
    3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    4) ilk iframe'den çıkıp ana sayfaya dönünüz
    5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
     */

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


        // sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println("tag Sayisi -> " + iframe.size());


        //ilk iframe'deki (Youtube) play butonuna tıklayınız. [@width='560']
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width='560']")));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();


        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
        Thread.sleep(2000);

    }


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        //driver.quit();
    }
}
