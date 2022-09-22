package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Task02 extends TestBaseBeforeAfter {
    /*
    “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    “Our Products” butonuna basin
    “Cameras product” i tiklayin
    Popup mesajini yazdirin
    “close” butonuna basin
    "WebdriverUniversity.com (IFrame)" linkini tiklayin
    "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    */
    @Test
    public void test01() throws InterruptedException {

        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //“Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.cssSelector("#frame"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Our Products']")).click();


        //“Cameras product” i tiklayin
        driver.findElement(By.cssSelector("#camera-img")).click();
        Thread.sleep(2000);


        //Popup mesajini yazdirin
        System.out.println("Mesaj -> " + driver.findElement(By.xpath("//*[@class='modal-body']")).getText());
        Thread.sleep(2000);


        //“close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        Thread.sleep(2000);


        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());


        driver.quit();
    }
}
