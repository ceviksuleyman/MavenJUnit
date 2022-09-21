package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C05_WindowHandle {
    /*
     Tests package’inda yeni bir class olusturun: WindowHandle2
     https://the-internet.herokuapp.com/windows adresine gidin.
     Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
     Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
     Click Here butonuna basın.
     Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
     Sayfadaki textin “New Window” olduğunu doğrulayın.
     Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
     */
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text = driver.findElement(By.xpath("//*[@class='no-js']")).getText();
        Assert.assertTrue(text.contains("Opening a new window"));


        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());


        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        /*
        Bir web sitesine gittignizde bir webelementi tikladiginizda yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() method'unu bir
        ArrayList'e atip buyun sayfalarin listesine ulasabilirim.
        Ilk actigim sayfanin index'i 0'dir,ikinci acilan sayfanin index'i 1'dir. Ve ikinci acilan pencerede
        ya da sekmede islem yapabilmek icin driver.switchTo().window(listAdi.get(index)) method'unu kullaniriz.
         */


        /*
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);
        String ikinciSayfaHandleDeger = "";
        for (String w : windowHandleSet) {

            if (!w.equals(ikinciSayfaHandleDeger)) ikinciSayfaHandleDeger = w;
        }
        */


        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());


        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='example']")).getText(), "New Window");


        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());
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
