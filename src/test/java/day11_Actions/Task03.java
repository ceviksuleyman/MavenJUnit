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

import java.util.List;

public class Task03 extends TestBaseBeforeClassAfterClass {

      /*
      Test01
      -  amazon gidin
      Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
      dropdown menude 40 eleman olduğunu doğrulayın
      Test02
      dropdown menuden elektronik bölümü seçin
      arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
      sonuc sayisi bildiren yazinin iphone icerdigini test edin
      ikinci ürüne relative locater kullanarak tıklayin
      ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
      Test03
      yeni bir sekme açarak amazon anasayfaya gidin
      dropdown’dan bebek bölümüne secin
      bebek puset aratıp bulundan sonuç sayısını yazdırın
      sonuç yazsının puset içerdiğini test edin
      5-üçüncü ürüne relative locater kullanarak tıklayin
      6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
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

        //dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        ddm.sendKeys("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        String aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        System.out.println("iphone arama sonucu -> " + aramaSonucu);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(aramaSonucu.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(ilkUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String fiyat = driver.findElement(By.cssSelector("#price_inside_buybox")).getText();
        System.out.println("Urun Fiyat -> " + fiyat);
        String urunTitle = driver.findElement(By.cssSelector("#productTitle")).getText();
        System.out.println("Urun Title -> " + urunTitle);
    }

    @Test
    public void test03() {
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");


        // dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        select = new Select(ddm);
        select.selectByIndex(3);

        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby stroller", Keys.ENTER);


        // sonuç yazsının "stroller" içerdiğini test edin
        String sonucYazi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(sonucYazi.contains("stroller"));


        // üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        WebElement ucuncuUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ikinciUrun));
        ucuncuUrun.click();


        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        // sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
