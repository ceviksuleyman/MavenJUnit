package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_KeyUpKeyDown extends TestBaseBeforeAfter {
      /*
       Bir Class olusturalim KeyboardActions1
       https://www.amazon.com sayfasina gidelim
       Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
       aramanin gerceklestigini test edin
        */
    @Test
    public void test01() {

        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");


        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("samsung").
                sendKeys(" ").keyDown(Keys.SHIFT). // shift tusuna basili tutmak icin
                sendKeys("a").keyUp(Keys.SHIFT). // shiht tusuna basmayi birakmak icin
                sendKeys("7").sendKeys("1").perform();
        actions.click().sendKeys(Keys.ENTER).perform();


        // aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='sg-col-inner']")).isDisplayed());

    }
}
