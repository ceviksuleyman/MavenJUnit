package day11_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class Task01 extends TestBaseBeforeClassAfterClass {

     /*
     1 => "http://webdriveruniversity.com/Actions" sayfasina gidin
     2 => Hover over Me First" kutusunun ustune gelin
     3 => Link 1" e tiklayin
     4 => Popup mesajini yazdirin
     5 => Popup'i tamam diyerek kapatin
     6 => “Click and hold" kutusuna basili tutun
     7 => “Click and hold" kutusunda cikan yaziyi yazdirin
     8 => “Double click me" butonunu cift tiklayin
     */

    @Test
    public void actions() throws InterruptedException {

        // 1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Thread.sleep(2000);


        // 2-Hover over Me First" kutusunun ustune gelin
        WebElement we = driver.findElement(By.xpath("//*[@class='dropbtn']"));
        actions.moveToElement(we).perform();


        // 3-Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]")).click();
        Thread.sleep(1000);


        // 4-popup mesajini yazdirin
        System.out.println("alert -> " + driver.switchTo().alert().getText());
        Thread.sleep(1000);


        // 5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(1000);


        // 6-“Click and hold" kutusuna basili tutun
        WebElement we2 = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(we2).perform();
        Thread.sleep(1000);


        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());
        Thread.sleep(1000);


        // 8-“Double click me" butonunu cift tiklayin
        WebElement we3 = driver.findElement(By.cssSelector("#double-click"));
        actions.doubleClick(we3).perform();
        Thread.sleep(2000);

        driver.quit();
    }
}
