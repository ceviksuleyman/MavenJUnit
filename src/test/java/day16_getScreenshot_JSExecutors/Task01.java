package day16_getScreenshot_JSExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Task01 extends TestBaseBeforeAfter {
    /*
    1- amazon anasayfaya gidin
    2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
    3- Nutella icin arama yapin sonucun Nutella icerdigini test edin
    4- ilk urunun goruntusunu alin
     */

    @Test
    public void test01() throws IOException {


        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");



        //amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfa = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfa, new File("target/screenShot/allPage" + tarih1 + ".jpeg"));



        // Nutella icin arama yapin sonucun Nutella icerdigini test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        WebElement nutellaSonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        File temp1 = nutellaSonuc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp1, new File("target/screenShot/nutellaSonuc.jpeg"));



        //ilk urunun goruntusunu alin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@data-csa-c-pos='1']"));
        File temp2 = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp2, new File("target/screenShot/ilkUrunNutella.jpeg"));
    }
}
