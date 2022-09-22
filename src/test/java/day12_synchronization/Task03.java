package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Task03 extends TestBaseBeforeAfter {
    /*
    1."http://webdriveruniversity.com/" adresine gidin
    2."Login Portal" a  kadar asagi inin
    3."Login Portal" a tiklayin
    4.Diger window'a gecin
    5."username" ve  "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    8.Ok diyerek Popup'i kapatin
    Ilk sayfaya geri donun
    Ilk sayfaya donuldugunu test edin
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");


        //"Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //"Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();


        //Diger window'a gecin
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));


        //"username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("mahmut");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("12345");



        //"login" butonuna basin
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(3000);


        //Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertEquals("validation failed", driver.switchTo().alert().getText());


        //Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();


        //Ilk sayfaya geri donun
        driver.switchTo().window(windowList.get(0));


        //Ilk sayfaya donuldugunu test edin
        WebElement login = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        WebElement contactUs = driver.findElement(By.xpath("//*[text()='CONTACT US']"));
        Assert.assertTrue(login.isDisplayed() && contactUs.isDisplayed());
    }
}
