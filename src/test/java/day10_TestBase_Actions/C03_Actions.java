package day10_TestBase_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {
     /*
     Yeni bir class olusturalim: MouseActions2
     https://demoqa.com/droppable adresine gidelim
     “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
     “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void mouseActions2() {

        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");


        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHere = driver.findElement(By.cssSelector("#droppable"));

        actions.dragAndDrop(dragMe, dropHere).perform();  // TestBase parent class'inda olusturdugumuz actions objesini aldik


        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        System.out.println(driver.findElement(By.xpath("//*[.='Dropped!']")).getText());
        Assert.assertNotEquals(dropHere, driver.findElement(By.xpath("//*[.='Dropped!']")).getText());

    }
}
