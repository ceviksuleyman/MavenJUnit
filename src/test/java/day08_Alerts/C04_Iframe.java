package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
    /*
    IFrame => Bir web sayfasina yerlestirilmis baska bir web sayfasidir  veya bir HTML dokumanin
    icine yerlestirilmis baska bir HTML dokumanidir.

    IFrame genellikle bir web sayfasina dokuman, video veya interaktif media gibi baska bir kaynaktan
    icerik eklemek icin kullanilir. <iframe> tag'i bir inline frame belirtir.
     */
    WebDriver driver;

    @Test
    public void test01() {
        // https://html.com/tags/iframe/ git
        driver.get("https://html.com/tags/iframe/");

        //Youtube videosunu calistirin
        WebElement ytFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(ytFrame);
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();
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
