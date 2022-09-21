package day10_TestBase_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class Task01 extends TestBaseBeforeAfter {

    /*
   Yeni bir class olusturalim : MouseActions3
   1 - https://www.amazon.com/ adresine gidelim
   2 - Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
   3 - “Create a list” butonuna basalim
   4 - Acilan sayfada “Your Lists” yazisi oldugunu teste delim
    */
    @Test
    public void test01() {

        //https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");


        // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        actions.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).perform();


        //“Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[.='Create a List']")).click();


        //Acilan sayfada “Your Lists” yazisi oldugunu teste delim
        System.out.println(driver.findElement(By.cssSelector("#my-lists-tab")).getText());
        Assert.assertEquals("Your Lists", driver.findElement(By.cssSelector("#my-lists-tab")).getText());

    }
}
