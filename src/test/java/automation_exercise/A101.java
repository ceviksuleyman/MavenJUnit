package automation_exercise;

import com.github.javafaker.Faker;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class A101 {

        /*
     Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.
     Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur.
     En az Web’de yapmak zorunlu.
    - Senaryoya üye kaydı oluşturmadan devam edilecek.
    - Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
    - Açılan ürünün siyah olduğu doğrulanır.
    - Sepete ekle butonuna tıklanır.
    - Sepeti Görüntüle butonuna tıklanır.
    - Sepeti Onayla butonuna tıklanır.
    - Üye olmadan devam et butonuna tıklanır.
    - Mail ekranı gelir.
    - Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
    - Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.
     */

    WebDriver driver;
    Faker faker = new Faker();
    Select select;
    Actions actions;

    WebDriverWait wait;


    @Test
    public void test() throws InterruptedException {


        //A101 sayfasına gidilir //"https://www.a101.com.tr/"
        driver.get("https://www.a101.com.tr/");
        System.out.println("A101 sayfasina gidildi.");


        //Çerazleri kabul et butonu tıklanır
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();
        System.out.println("Cerezler kabul edildi.");


        //giyim aksesuar tıklanır
        WebElement giyimAksesuar = driver.findElement(By.cssSelector(".desktop-menu>:nth-child(4)"));
        actions.moveToElement(giyimAksesuar).perform();
        Thread.sleep(1000);
        System.out.println("Giyim ve aksesuar kategorisi secildi.");


        //Kategorilerden kadın içgiyim seçilir
        System.out.println("Kategorilerden icgiyim secildi");


        //seçeneklerden kadın dizaltı çorap seçilir
        driver.findElement(By.xpath("//*[@title='Dizaltı Çorap']")).click();
        System.out.println("Diz Alti Corap Secildi");


        //İlk çıkan çorap tıklanır
        driver.findElement(By.xpath("(//*[@class=' ls-is-cached lazyloaded'])[1]")).click();
        System.out.println("Ilk cikan corap secildi.");


        //Siyah olduğu doğrulanır
        String actualColor = driver.findElement(By.xpath("//*[.='SİYAH']")).getText();
        Assert.assertEquals("SİYAH", actualColor);
        System.out.println("Secilen corabin siyah oldugu dogrulandi.");


        //sayfa yenilenir
        driver.navigate().refresh();
        Thread.sleep(1000);


        //Sepete ekle butonu tıklanır
        driver.findElement(By.cssSelector(".add-to-basket.button")).click();
        System.out.println("Sepete ekle butonu tiklandi");


        //Sepeti görüntüle butonu tıklanır
        driver.findElement(By.cssSelector("a[class=go-to-shop]")).click();
        System.out.println("Sepeti goruntule butonu tiklandi");
        Thread.sleep(1000);


        //Sepeti onayla butonu tıklanır
        driver.findElement(By.cssSelector(".button.green.checkout-button")).click();
        System.out.println("Sepeti onayla butonu tiklandi");


        //Üye olmadan devam et butonu tıklanır
        driver.findElement(By.cssSelector(".auth__form__proceed")).click();
        System.out.println("Uye olmadan devam et butonu tiklandi");
        Thread.sleep(1000);


        //Mail ekranı gelir. Ekranın geldiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='user_email']")).isDisplayed());
        System.out.println("Mail ekraninin geldigi dogrulanir");


        //Bir mail adresi girilir.
        WebElement mail = driver.findElement(By.xpath("//*[@name='user_email']"));
        mail.sendKeys(faker.internet().emailAddress());
        mail.sendKeys(Keys.ENTER);
        System.out.println("Mail adresi girilir");


        //Adres ekranı gelir. Ekranın geldiği doğrulanır.
        Assert.assertTrue(driver.findElement(By.cssSelector(".addresses")).isDisplayed());
        System.out.println("Adres ekraninin geldigi dogrulanir");


        //Adres oluştur seçeneğine tıklanır
        driver.findElement(By.xpath("(//*[@class='new-address js-new-address'])[1]")).click();
        System.out.println("Adres olustur secenegi tiklanir");


        //Adres Başlığı
        WebElement adresBasligi = driver.findElement(By.cssSelector("input[name=title]"));
        actions.click(adresBasligi).sendKeys("Ev").
                sendKeys(Keys.TAB).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                perform();
        WebElement sehir = driver.findElement(By.cssSelector(".js-cities"));
        select = new Select(sehir);
        select.selectByIndex(35);
        Thread.sleep(1000);
        WebElement ilce = driver.findElement(By.cssSelector(".js-township"));
        select = new Select(ilce);
        select.selectByIndex(3);
        Thread.sleep(1000);
        WebElement mah = driver.findElement(By.cssSelector(".js-district"));
        select = new Select(mah);
        select.selectByIndex(3);
        WebElement adress = driver.findElement(By.cssSelector(".js-address-textarea"));
        actions.click(adress).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER). //Kaydet butonuna tıklanır
                perform();
        System.out.println("Adres ekleme ekrani doldurulur");
        System.out.println("Kaydet butonuna basilir");
        Thread.sleep(3000);


        //kargo
        WebElement kargo = driver.findElement(By.xpath("(//*[@class='js-checkout-cargo-item'])[1]"));
        if (!kargo.isSelected()) kargo.click();
        Thread.sleep(1000);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement kargo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='js-checkout-cargo-item'])[1]")));
        //if (!kargo.isSelected()) kargo.click();


        //Kaydet ve devam et butonu tıklanır
        driver.findElement(By.cssSelector(".button.block.green.js-proceed-button")).click();
        System.out.println("Kaydet ve devam et butonuna tiklanir.");


        //Ödeme ekranına gelindiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-checkout js-page-checkout js-tab-box']")).isDisplayed());
        System.out.println("Odeme ekranina gelindigi dogrulanir.");
    }

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    @After
    public void tearDown() {

        //driver.quit();
    }
}
