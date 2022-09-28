package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;


public class Task02_JSEx extends TestBaseBeforeAfter {
     /*
    Yeni bir class olusturun : ScroolInto
    hotelmycamp anasayfasina gidin
    2 farkli test methodu olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden
    ust sira ortadaki odayi tiklayin istediginiz oda inceleme sayfasi acildigini test  edin
     */

    @Test
    public void testAction01() {

        driver.get("https://www.hotelmycamp.com");

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//p//a[@class='btn-custom'])[2]")).click();
    }

    @Test
    public void testJsExecutor02() {

        driver.get("https://www.hotelmycamp.com");

        WebElement oda = driver.findElement(By.xpath("(//p//a[@class='btn-custom'])[2]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);", oda);

        jse.executeScript("arguments[0].click()", oda);

    }
}
