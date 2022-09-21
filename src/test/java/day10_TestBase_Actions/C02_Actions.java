package day10_TestBase_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C02_Actions extends TestBaseBeforeClassAfterClass {

    /*
    1 - Yeni bir class olusturalim:MouseActions1
    2 - https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3 - Cizili alan uzerinde sag click yapalim
    4 - Alert’te cikan yazinin “You selected a context menu”oldugunu test edelim.
    5 - Tamam diyerek alert’i kapatalim
    6 - Elemental Selenium linkine tiklayalim
    7 - Acilan sayfada h1 taginda “Elemental Selenium” yazdigini teste delim
     */

    /*
       Action Mouse Methods
    ➢ doubleClick(): WebElement’e çift tıklama yapar
    ➢ clickAndHold(): WebElement uzerinde click yapili  olarak bizden komut bekler.
    ➢ dragAndDrop(): WebElement’i bir noktadan diğerine sürükler ve bırakır
    ➢ moveToElement(): Mouse’u istedigimiz WebElement’in uzerinde tutar
    ➢ contextClick(): Mouse ile istedigimiz WebElement’e sag tiklama yapar.
     */

    @Test
    public void mouseActions1() throws InterruptedException {

        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(cizgiliAlan).perform(); // locate edilen alana sag click yap

        // Alert’te cikan yazinin “You selected a context menu”oldugunu test edelim.
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());


        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(3000);


        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@target='_blank']")).click();


        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini teste delim
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        /*
        Object[] arr = driver.getWindowHandles().toArray();
        driver.switchTo().window(arr[1].toString());
        */


        System.out.println(driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.tagName("h1")).getText());

        driver.quit();
    }
}
