package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class Task02 extends TestBaseBeforeClassAfterClass {

   /*
    => https://html.com/tags/iframe/ sayfasina gidelim
    => video’yu gorecek kadar asagi inin
    => videoyu izlemek icin Play tusuna basin
    => videoyu calistirdiginizi test edin
     */

    @Test
    public void test01() {

        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement frame = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(frame);
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();

        //videoyu calistirdiginizi test edin
    }
}
