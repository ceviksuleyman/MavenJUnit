package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C01_SynchronizationWait extends TestBaseBeforeAfter {
     /*
     1. Bir class olusturun : WaitTest
     2. Iki tane metod olusturun : implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
     3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
     4. Remove butonuna basin.
     5. "It's gone!" mesajinin goruntulendigini dogrulayin.
     6. Add buttonuna basin
     7. It's back mesajinin gorundugunu test edin
     */

    @Test
    public void implicitWait01() {
        /*
        implicitWait() kullandigimiz bu method'da locate ettigimiz butun WE'ler icin maksimum belirttigimiz
        sure altinda butun WE'ler icin bekler
         */

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[@autocomplete='off']")).click();


        //"It's gone!" mesajinin goruntulendigini dogrulayin.
        String message = driver.findElement(By.cssSelector("*[id='message']")).getText();
        System.out.println("it's gone -> " + message);
        Assert.assertTrue(driver.findElement(By.cssSelector("*[id='message']")).isDisplayed());


        //Add buttonuna basin
        driver.findElement(By.xpath("//*[@autocomplete='off']")).click();


        //It's back mesajinin gorundugunu test edin
        String message2 = driver.findElement(By.cssSelector("*[id='message']")).getText();
        System.out.println("It's back -> " + message2);
        Assert.assertTrue(driver.findElement(By.cssSelector("*[id='message']")).isDisplayed());
    }

    @Test
    public void explicitWait02() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[@autocomplete='off']")).click();


        //"It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        /*
        explicitWait() itsGoneWE gorunur olmasini beklerken o WE'nin locate'ini kullanarak assert
        yapmak sorun olur ve expection firlatir.
        Henuz gorulmeyen bir WE'in locate edilmesi de otomasyon icin mumkun olmaz.
        Bu durumda bekleme islemi icin explicitWait() method'unu locate ile birlikte kullaniriz.
         */


        //Add buttonuna basin
        driver.findElement(By.xpath("//*[@autocomplete='off']")).click();


        //It's back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());
    }
}
