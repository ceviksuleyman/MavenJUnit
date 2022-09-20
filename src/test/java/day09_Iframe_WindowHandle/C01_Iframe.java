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

public class C01_Iframe {
    /*
    IFrame => Bir web sayfasina yerlestirilmis baska bir web sayfasidir  veya bir HTML dokumanin
    icine yerlestirilmis baska bir HTML dokumanidir.

    IFrame genellikle bir web sayfasina dokuman, video veya interaktif media gibi baska bir kaynaktan
    icerik eklemek icin kullanilir. <iframe> tag'i bir inline frame belirtir.
     */
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        // https://html.com/tags/iframe/ git
        driver.get("https://html.com/tags/iframe/");

        //Youtube videosunu calistirin
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();
        Thread.sleep(3000);

        /*
        Bir web sitesinde bir video(youtube vb.) varsa ve <iframe> tag'i icerisindeyse bu video'yu direkt
        locate edip calistirmak dinamik olmaz cunku link degisebilir ve locate'i calismaz.
        Bunun icin butun frame'leri bir ArrayList'e atip index ile frame' i secip sonrasinda play tusunu
        locate edip calistirabiliriz.
         */

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

        driver.close();
    }
}
