package day11_Actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    // “firstName” giris kutusuna bir isim yazin
    // “surname” giris kutusuna bir soyisim yazin
    // “email” giris kutusuna bir email yazin
    // “email” onay kutusuna emaili tekrar yazin
    // Bir sifre girin
    // Tarih icin gun secin
    // Tarih icin ay secin
    // Tarih icin yil secin
    // Cinsiyeti secin
    // Kaydol butonuna basın
    // Sayfayi kapatin
    @Test
    public void test01() throws InterruptedException {

        // "https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");


        // “create new account”  butonuna basin
        driver.findElement(By.xpath("(//*[@href='#'])[2]")).click();


        /*
        faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi uretecegimiz
        veriler yerine bizim icin random veriler uretir ve isimizi kolaylastirir
        Faker class'ini kullanmak icin mvnrepostory.com adresinden java-faker kutuphanesini aratir
        ve en cok kullanilani pom.xml dosyasina ekleriz ve faker class'indan bir obje olusturup email icin
        faker.internet() method'unu kullanarak emailAddress() method'unu seceriz password icinde ayni internet()
        method'unu kullaniriz. isim ve soyisim icin faker.name() method'u ile firtname() ve lastname() method'unu
        kullaniriz.
         */

        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//*[@name='firstname']"));
        String email = faker.internet().emailAddress(); //ayni maili vermesi icin atadik
        actions.click(name).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("21").
                sendKeys(Keys.TAB).sendKeys("Oca").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();


        //driver.quit();
    }
}
