package automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class TC08 extends TestBaseBeforeAfter {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Ürünler' düğmesine tıklayın
     5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
     6. Ürün listesi görünür
     7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
     8. Kullanıcı, ürün detay sayfasına yönlendirilir
     9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
     */

    @Test
    public void test01() {

        //'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");


        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.cssSelector("section[id=slider]")).isDisplayed());


        //'Ürünler' düğmesine tıklayın
        driver.findElement(By.cssSelector(".material-icons.card_travel")).click();



        // Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.cssSelector(".col-sm-9.padding-right")).isDisplayed());



        //Ürün listesi görünür    .features_items>div   //div//div[@class='product-image-wrapper']
        List<WebElement> urunList = driver.findElements(By.xpath("//div//div[@class='product-image-wrapper']"));
        for (WebElement w : urunList) {
            System.out.println(w.getText() + "\n");
        }
        Assert.assertTrue(driver.findElement(By.xpath("//div//div[@class='product-image-wrapper']")).isDisplayed());



        // İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));

        // JavascriptExecutor kullanmak icin ilk adim olarak driver'i JavascriptExecutor’a cast edelim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", ilkUrun);
        jse.executeScript("arguments[0].click()", ilkUrun);



        //Kullanıcı, ürün detay sayfasına yönlendirilir
        Assert.assertTrue(driver.findElement(By.cssSelector(".product-information")).isDisplayed());



        //Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        List<WebElement> urunBilgisi = driver.findElements(By.cssSelector(".product-information"));
        System.out.println("URUN BILGISI");
        for (WebElement w : urunBilgisi) {
            System.out.println(w.getText() + "\n");
        }
        Assert.assertTrue(driver.findElement(By.cssSelector(".product-information")).isDisplayed());
    }
}
