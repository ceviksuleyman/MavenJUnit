package automation_exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class A101team2 extends TestBaseBeforeAfter {

    /*
Uçtan uca ödeme ekranına kadar Selenium'da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.
Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur.
En az Web'de yapmak zorunlu.
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
    Select select;
    WebDriverWait wait;

    Faker faker = new Faker();

    @Test
    public void test() throws InterruptedException {
        //A101 sayfasına gidilir //"https://www.a101.com.tr/"
        driver.get("https://www.a101.com.tr/");
        System.out.println("A101 sayfasina gidildi.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Çerazleri kabul et butonu tıklanır
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();
        System.out.println("Cerezler kabul edildi.");
        //giyim aksesuar tıklanır
        WebElement giyimAksesuar = driver.findElement(By.cssSelector(".desktop-menu>:nth-child(4)"));
        actions.moveToElement(giyimAksesuar).perform();
        System.out.println("Giyim ve aksesuar kategorisi secildi.");
        //Kategorilerden kadın içgiyim seçilir
        System.out.println("Kategorilerden icgiyim secildi.");
        //seçeneklerden kadın dizaltı çorap seçilir
        driver.findElement(By.xpath("//*[@title='Dizaltı Çorap']")).click();
        System.out.println("Diz Alti Corap secildi.");
        // Renk alanından Siyah seçimi yapılır.
        driver.findElement(By.id("attributes_integration_colourSİYAH")).click();
        Assert.assertTrue(driver.findElement(By.id("attributes_integration_colourSİYAH")).isSelected());
        //İlk çıkan çorap tıklanır
        WebElement firstCorap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=' ls-is-cached lazyloaded'])[1]")));
        firstCorap.click();
        System.out.println("Ilk cikan corap secildi.");
        //Siyah olduğu doğrulanır
        String actualColor = driver.findElement(By.xpath("//*[.='SİYAH']")).getText();
        Assert.assertEquals("SİYAH", actualColor);
        System.out.println("Secilen corabin siyah oldugu dogrulandi.");
        //sayfa yenilenir
        //driver.navigate().refresh();
        //Sepete ekle butonu tıklanır
        driver.findElement(By.cssSelector(".add-to-basket.button")).click();
        System.out.println("Sepete ekle butonu tiklandi.");
        //Sepeti görüntüle butonu tıklanır
        driver.findElement(By.cssSelector("a[class=go-to-shop]")).click();
        System.out.println("Sepeti goruntule butonu tiklandi.");
        //Sepeti onayla butonu tıklanır
        driver.findElement(By.cssSelector(".button.green.checkout-button")).click();
        System.out.println("Sepeti onayla butonu tiklandi.");
        //Üye olmadan devam et butonu tıklanır
        driver.findElement(By.cssSelector(".auth__form__proceed")).click();
        System.out.println("Uye olmadan devam et butonu tiklandi.");
        //Mail ekranı gelir. Ekranın geldiği doğrulanır
        WebElement userEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='user_email']")));
        try {
            Assert.assertTrue(userEmail.isDisplayed());
            System.out.println("Mail ekraninin geldigi dogrulanir");
        } catch (Exception e) {
            System.out.println("Mail ekranini izlenemedi");
        }
        //Bir mail adresi girilir.
        WebElement mail = driver.findElement(By.xpath("//*[@name='user_email']"));
        mail.sendKeys(faker.internet().emailAddress());
        if (mail.getText() != null) {
            System.out.println("Mail adresi girildiği izlenebilir.");
        } else System.out.println("Mail adresi girilmemiştir.");
        mail.sendKeys(Keys.ENTER);
        //Adres ekranı gelir. Ekranın geldiği doğrulanır.
        Assert.assertTrue(driver.findElement(By.cssSelector(".addresses")).isDisplayed());
        System.out.println("Adres ekraninin geldigi dogrulanir");
        //Adres oluştur seçeneğine tıklanır
        driver.findElement(By.xpath("(//*[@class='new-address js-new-address'])[1]")).click();
        System.out.println("Adres olustur secenegi tiklanir.");
        //Adres Başlığı
        WebElement adresBasligi = driver.findElement(By.cssSelector("input[name=title]"));
        actions.click(adresBasligi)
                .sendKeys("Ev")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(11))
                // .sendKeys(faker.phoneNumber().phoneNumber())
                .perform();
        //il Random select
        WebElement sehir = driver.findElement(By.xpath("//*[@name='city']"));
        select = new Select(sehir);
        List<WebElement> sehirCount = select.getOptions();
        // System.out.println("size = " + sehirCount.size() );
        Random random = new Random();
        int index = random.nextInt(sehirCount.size());
        while (index == 1) {
            index = random.nextInt(sehirCount.size());
        }
        select.selectByIndex(index);
        Thread.sleep(9000);
        // select.selectByIndex(34);
        //ilçe Random select
        WebElement ilce = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-township")));
        //WebElement ilce = driver.findElement(By.cssSelector(".js-township"));
        select = new Select(ilce);
        List<WebElement> ilceCount = select.getOptions();
        //random = new Random();
        index = random.nextInt(ilceCount.size());
        while (index == 1) {
            index = random.nextInt(ilceCount.size());
        }
        select.selectByIndex(index);
        // Mahalle random seçim
        WebElement mah = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-district")));
        select = new Select(mah);
        List<WebElement> mahCount = select.getOptions();
        //random = new Random();
        index = random.nextInt(mahCount.size());
        while (index == 1) {
            index = random.nextInt(mahCount.size());
        }
        // ilçe seçimi yapılmadan mahalle seçimi alanı seçilemediği (dropDown içerisindeki obejeler yüklenemedi ve selected yapılamadığını farkettik)
        // bundan dolayı elementToBeClickable kullanıldı. Fakat hala StaleElementReferenceException hatası alınıyordu. Bundan dolayı
        // aşağıda try-catch bloğuna ve for döngüsüne alındı
        for (int retry = 0; retry < 5; retry++) {
            try {
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException ex) {
                ex.toString();
            }
        }
        WebElement adress = driver.findElement(By.cssSelector(".js-address-textarea"));
        actions.click(adress).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER). //Kaydet butonuna tıklanır
                perform();
        System.out.println("Adres ekleme ekrani doldurulur.");
        System.out.println("Kaydet butonuna basilir.");
        // Kargo secimi yapilir
        WebElement kargo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='js-checkout-cargo-item'])[1]")));
        System.out.println("kargo selected " + kargo.isSelected());
        for (int retry = 0; retry < 5; retry++) {
            try {
                if (!kargo.isSelected()) kargo.click();
                break;
            } catch (StaleElementReferenceException ex) {
                ex.toString();
            }
        }
        //Kaydet ve devam et butonu tıklanır
        WebElement saveAndContinue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.block.green.js-proceed-button")));
        saveAndContinue.click();
        System.out.println("Kaydet ve devam et butonuna tiklanir.");
        //Ödeme ekranına gelindiği doğrulanır
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='name'])[2]")));
        Assert.assertTrue(name.isDisplayed());
        System.out.println("Odeme ekranina gelindigi dogrulanir.");
    }
}
