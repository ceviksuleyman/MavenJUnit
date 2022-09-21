package day11_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_ActionsTAB extends TestBaseBeforeAfter {
    /*
    1 - https://www.facebook.com adresine gidelim
    2 - Yeni hesap olustur butonuna basalim
    3 - Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
     */
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("(//*[@href='#'])[2]")).click();

        WebElement name = driver.findElement(By.xpath("//*[@name='firstname']"));
        name.sendKeys("Ali");
        actions.sendKeys(Keys.TAB).sendKeys("Can").
                sendKeys(Keys.TAB).sendKeys("alican@gmail.com").
                sendKeys(Keys.TAB).sendKeys("alican@gmail.com").
                sendKeys(Keys.TAB).sendKeys("12454645").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("21").
                sendKeys(Keys.TAB).sendKeys("Oca").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(5000);
        driver.quit();
    }
}
