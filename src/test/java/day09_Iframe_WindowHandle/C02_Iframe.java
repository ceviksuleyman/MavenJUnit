package day09_Iframe_WindowHandle;

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

public class C02_Iframe {
      /*
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
     */

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText());


        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr")); //frame gecis yapmadan once id ile orayi locate ettik
        driver.switchTo().frame(textBox); // locate ettigimiz frame gecmek icin bu method'u kullan

        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear();
        textBoxFrame.sendKeys("Merhaba Dunya!");


        driver.switchTo().defaultContent(); //ustte frame girmistik teste devam edebilmek icin ciktik


        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText());

        Thread.sleep(3000);
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

        driver.quit();
    }
}
