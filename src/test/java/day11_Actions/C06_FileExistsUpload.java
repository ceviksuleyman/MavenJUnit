package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C06_FileExistsUpload extends TestBaseBeforeAfter {
    /*
   => https://the-internet.herokuapp.com/upload adresine gidelim
   => chooseFile butonuna basalim
   => Yuklemek istediginiz dosyayi secelim.
   => Upload butonuna basalim.
   => “File Uploaded!” textinin goruntulendigini test edelim.
   */
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        //Dosya sec butonuna basalim
        WebElement fileUpload = driver.findElement(By.cssSelector("#file-upload"));
        /*
        Dosya sec butonuna direkt basamayabiliriz cunku W10'a mudahaleye izin vermeyebilir.
        Bu yuzden Dosya Sec botonunu locate edip sendKeys() method'u ile dosya yolunu gonderebiliriz.
         */


        //Yuklemek istediginiz dosyayi secelim.
        fileUpload.sendKeys(
                "C:\\Users\\User\\IdeaProjects\\com.JUnit\\src\\test\\java\\day11_Actions\\car.png");


        //Upload butonuna basalim.
        driver.findElement(By.cssSelector("#file-submit")).click();


        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
