package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class A101 extends TestBaseBeforeAfter {

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

    @Test
    public void test() throws InterruptedException {


        //A101 sayfasına gidilir //"https://www.a101.com.tr/"
        driver.get("https://www.a101.com.tr/");
        System.out.println("A101 sayfasina gidildi.");


        //Çerazleri kabul et butonu tıklanır
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();
        System.out.println("Cerezler kabul edildi.");


        // Çıkmadan önce gözat kısmı kapatılır
        // driver.findElement(By.xpath("//*[text()='X']")).click();


        //giyim aksesuar tıklanır
        driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]")).click();
        System.out.println("Giyim ve aksesuar kategorisi secildi.");


        //Kategorilerden kadın içgiyim seçilir
        driver.findElement(By.xpath("//a[@data-value='1565']")).click();
        Thread.sleep(2000);
        System.out.println("Kategorilerden icgiyim secildi");


        //seçeneklerden kadın dizaltı çorap seçilir
        driver.findElement(By.xpath("//a[@data-value='1567']")).click();
        System.out.println("Seceneklerden dizalti corap secildi.");


        //İlk çıkan çorap tıklanır
        driver.findElement(By.xpath("//*[@alt='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")).click();
        System.out.println("Ilk cikan corap secildi.");


        //Siyah olduğu doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='SİYAH']")).isDisplayed());
        System.out.println("Secilen corabin siyah oldugu dogrulandi.");


        //sayfa yenilenir
        driver.navigate().refresh();


        //Sepete ekle butonu tıklanır
        driver.findElement(By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        System.out.println("Sepete ekle butonu tiklandi");
        Thread.sleep(3000);


        //Sepeti görüntüle butonu tıklanır
        driver.findElement(By.xpath("(//*[text()='Sepeti Görüntüle'])[2]")).click();
        System.out.println("Sepeti goruntule butonu tiklandi");
        Thread.sleep(3000);


        //Sepeti onayla butonu tıklanır
        driver.findElement(By.xpath("//*[@class='button green checkout-button block js-checkout-button']")).click();
        System.out.println("Sepeti onayla butonu tiklandi");
        Thread.sleep(3000);


        //Üye olmadan devam et butonu tıklanır
        driver.findElement(By.xpath("//*[@title='ÜYE OLMADAN DEVAM ET']")).click();
        System.out.println("Uye olmadan devam et butonu tiklandi");
        Thread.sleep(3000);


        //Mail ekranı gelir. Ekranın geldiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-inner']")).isDisplayed());
        System.out.println("Mail ekraninin geldigi dogrulanir");
        Thread.sleep(3000);


        //Bir mail adresi girilir.
        WebElement mail = driver.findElement(By.xpath("//*[@name='user_email']"));
        Faker faker = new Faker();
        mail.sendKeys(faker.internet().emailAddress());
        mail.sendKeys(Keys.ENTER);
        System.out.println("Mail adresi girilir");
        Thread.sleep(3000);


        //Adres ekranı gelir. Ekranın geldiği doğrulanır.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-checkout js-page-checkout js-tab-box']")).isDisplayed());
        System.out.println("Adres ekraninin geldigi dogrulanir");
        Thread.sleep(3000);


        //Adres oluştur seçeneğine tıklanır
        driver.findElement(By.xpath("(//*[@class='new-address js-new-address'])[1]")).click();
        System.out.println("Adres olustur secenegi tiklanir");


        /*//Adres Başlığı
        WebElement adresBasligi = driver.findElement(By.xpath("//*[@placeholder='Ev adresim, iş adresim vb.']"));
        actions.click(adresBasligi).sendKeys("Ev").sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).
                sendKeys(faker.address().country()).sendKeys(Keys.TAB).
                sendKeys("BURSA").sendKeys(Keys.TAB).
                sendKeys("NİLÜFER").sendKeys(Keys.TAB).
                sendKeys("BEŞEVLER MAH").sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).sendKeys(Keys.ENTER).perform();

         */


        //Adres ekleme kısımları doldurulur
        Thread.sleep(3000);
        System.out.println("Adres ekleme ekrani doldurulur");


        //Adres Başlığı
        driver.findElement(By.xpath("//*[@placeholder='Ev adresim, iş adresim vb.']")).sendKeys("Ev");
        Thread.sleep(3000);
        //Ad
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Zeliha");
        Thread.sleep(3000);
        //Soyad
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("QA");
        Thread.sleep(3000);
        //Telefon
        driver.findElement(By.xpath("//*[@name='phone_number']")).sendKeys("5436549871");
        Thread.sleep(3000);
        //İl seçiniz
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("BURSA");
        Thread.sleep(4000);
        //İlçe seçiniz
        driver.findElement(By.xpath("//*[@name='township']")).sendKeys("NİLÜFER");
        Thread.sleep(5000);
        //Mahalle seçiniz
        driver.findElement(By.xpath("//*[@class='js-district']")).sendKeys("BEŞEVLER MAH");
        Thread.sleep(4000);
        //Adresinizi yazınız
        driver.findElement(By.xpath("//*[@name='line']")).sendKeys(faker.address().fullAddress()); //Bu kısımda her seferinde yeni adres girilmesini istiyor.
        Thread.sleep(4000);
        Thread.sleep(3000);



        //Kaydet butonuna tıklanır
        driver.findElement(By.xpath("//*[@class='button green js-set-country js-prevent-emoji']")).sendKeys(Keys.ENTER);
        System.out.println("Kaydet butonuna basilir");
        Thread.sleep(5000);
        //Kaydet ve devam et butonu tıklanır
        driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']")).click();
        System.out.println("Kaydet ve devam et butonuna tiklanir.");
        Thread.sleep(3000);
        //Ödeme ekranına gelindiği doğrulanır
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-checkout js-page-checkout js-tab-box']")).isDisplayed());
        System.out.println("Odeme ekranina gelindigi dogrulanir.");




    }
}
