package day15_excel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_getScreenshot extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException, IOException {

        //amazon sayfasina gidip tum sayfanin ekran goruntusunu alalim
        driver.get("https://www.amazon.com");

        /*
        Bir web sayfanin ekran goruntusunu alabilmek icin TakesScreenshot den bir obje olusturup
        File class'indan gecici bir degiskene TakesSS'dan olusturdgum obje ile getScreenshotAs()
        method'unu kullanarak gecici bir file olusturur.
         */

        System.out.println(tarih2);

        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaResmi = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/screenShot/allPage" + tarih1 + ".jpeg"));
    }
}
