package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_SynchronizationWait extends TestBaseBeforeAfter {
/*
    -> Bir metod olusturun : isEnabled()
    -> https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    -> Textbox’in etkin olmadigini(enabled) dogrulayın
    -> Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    -> “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    -> Textbox’in etkin oldugunu(enabled) dogrulayın
     */

    @Test
    public void isEnabled01() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.cssSelector("input[type=text]")).isEnabled());

        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement textBox = driver.findElement(By.xpath("(//*[@type='button'])[2]"));
        textBox.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));


        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.cssSelector("*[id=message]")).isDisplayed());

        //Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textBox.isEnabled());
    }
}
