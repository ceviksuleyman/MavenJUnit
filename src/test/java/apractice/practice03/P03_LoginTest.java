package apractice.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class P03_LoginTest extends TestBaseBeforeAfter {


    @Test
    public void testLogin() {

        // https://www.koalaresorthotels.com/ sayfasina gidin
        driver.get("https://www.koalaresorthotels.com/");

        // Sign in butonuna tiklayin
        driver.findElement(By.cssSelector("#navLogon")).click();


        // Log in ekraninin gorunurlugunu dogrulayin
        // 1.yol
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        Assert.assertEquals("Log in", driver.findElement(By.xpath("//h2")).getText());


        //2.yol
        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


        //3.yol
        Assert.assertTrue("Url yanlis", driver.getCurrentUrl().contains("Logon"));


        //4.yol
        WebElement username = driver.findElement(By.cssSelector("#UserName"));
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        WebElement signInButton = driver.findElement(By.cssSelector("#btnSubmit"));

        Assert.assertTrue(username.isDisplayed() && password.isDisplayed() && signInButton.isDisplayed());

        /*
         asserttrue -->  dogruysa  onayla geç, yanlişsa çalışma dur, hata ver, notumu goster.
         assertFalse -->  yanlışsa onayla geç, doğruysa çalışma dur, hata ver, notumu goster
         assertEquals -->  eşitse onayla gec, eşit değilse çalışma dur, hata ver, notumu goster
         assertNotEquals -->  eşit değilse onayla geç, eşitse çalışma dur, hata ver, notumu goster.
         */

    }
}
