package day16_getScreenshot_JSExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C02_getScreenshot extends TestBaseBeforeAfter {

    @Test
    public void test() throws IOException, IOException {

        //amazon'a gidelim
        driver.get("https://www.amazon.com");

        //nutella ara
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //arama sonucunun ekran goruntusunu al
        WebElement nutellaAramaSonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        File temp1 = nutellaAramaSonuc.getScreenshotAs(OutputType.FILE);

        /*
        Sadece webelementin ss'ini alacaksak TakeScreenshot() interface'ini kullanmaya gerek yok
        Locate ettigimiz webelementi direk gecici bir file'a atip FileUtils ile kopyalayip yolunu(path) belirtiriz.
         */
        FileUtils.copyFile(temp1, new File("target/screenShot/nutellaAramaSonuc.jpeg"));
    }
}
