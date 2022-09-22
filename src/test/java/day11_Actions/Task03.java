package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.Arrays;
import java.util.List;

public class Task03 extends TestBaseBeforeClassAfterClass {

      /*
      Test01
      1 - amazongidin
      2 - Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
      3 - dropdown menude 40 eleman olduğunu doğrulayın

      Test02
      1 - dropdown menuden elektronik bölümü seçin
      2 - arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
      3 - sonuc sayisi bildiren yazinin iphone icerdigini test edin
      4 - ikinci ürüne relative locater kullanarak tıklayin
      5 - ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

      Test03
      1 - yeni bir sekme açarak amazon anasayfaya gidin
      2 - dropdown’dan bebek bölümüne secin
      3 - bebek puset aratıp bulunan sonuç sayısını yazdırın
      4 - sonuç yazsının puset içerdiğini test edin
      5 - üçüncü ürüne relative locater kullanarak tıklayin
      6 - title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

      Test4
      1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */

    Select select;

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");


        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        // dropdown menude 40 eleman olduğunu doğrulayın
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        select = new Select(ddm);

        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        for (WebElement w : ddmList) {

            System.out.println(w.getText());
        }
        Assert.assertNotEquals(40, ddmList.size());

    }

    @Test
    public void test02() {

        driver.get("https://www.amazon.com");

        //1 - dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        ddm.sendKeys("Electronics");


        //2 - arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        String aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        System.out.println("iphone arama sonucu -> " + aramaSonucu);


        //3 - sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(aramaSonucu.contains("iphone"));


        //4 - ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(ilkUrun));
        ikinciUrun.click();


        //5 - ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String fiyat = driver.findElement(By.cssSelector("#price_inside_buybox")).getText();
        System.out.println("Urun Fiyat -> " + fiyat);
        String urunTitle = driver.findElement(By.cssSelector("#productTitle")).getText();
        System.out.println("Urun Title -> " + urunTitle);
    }

    @Test
    public void test03() {

        //1 - yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");


        //2 - dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        select = new Select(ddm);
        select.selectByIndex(3);


        //3 - bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby stroller", Keys.ENTER);


        //4 - sonuç yazsının "stroller" içerdiğini test edin
        String sonucYazi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(sonucYazi.contains("stroller"));


        //5 - üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        WebElement ucuncuUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ikinciUrun));
        ucuncuUrun.click();


        //6 - title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urunFiyat = driver.findElement(By.xpath("(//*[@class='a-price aok-align-center'])[1]")).getText();
        System.out.println("Bebek puset fiyat -> " + urunFiyat);
        String urunTitle = driver.findElement(By.cssSelector("#productTitle")).getText();
        System.out.println("Bebek puset Urun Title -> " + urunTitle);

        driver.findElement(By.cssSelector("#add-to-cart-button")).click(); // sepete ekle


        //Test4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        driver.findElement(By.cssSelector("#nav-cart")).click();  //sepete git
        String sepetFiyat = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();
        String sepetUrunTitle = driver.findElement(By.xpath("//*[@class='a-truncate-full a-offscreen']")).getText();
        System.out.println("sepetteki urun fiyati -> " + sepetFiyat);
        System.out.println("sepetteki urun ismi -> " + sepetUrunTitle);

        Assert.assertEquals(urunFiyat, sepetFiyat);
        Assert.assertEquals(urunTitle, sepetUrunTitle);
    }
}
