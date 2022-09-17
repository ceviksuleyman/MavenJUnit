package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropdownHandle {
    /*
   Bir class oluşturun:C3_DropDownAmazon
   https://www.amazon.com/ adresinegidin.
   -Test1
   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin
   -Test2
   1.Kategori menusunden Books secenegini secin
   2.Arama kutusuna Java yazin vearatin
   3.Bulunan sonuc sayisiniyazdirin
   4.Sonucun Java kelimesini icerdigini testedin
   */
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }
        int dropDownList = drops.size();
        int unexpected = 45;
        Assert.assertNotEquals(unexpected, dropDownList);
    }

    @Test
    public void test02() throws InterruptedException {

        // Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
        Thread.sleep(2000);


        // Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);


        //Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());


        //Sonucun Java kelimesini icerdigini test edin
        String expected = "Java";
        String actualSonuc = sonucSayisi.getText();
        Assert.assertTrue(actualSonuc.contains(expected));
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
