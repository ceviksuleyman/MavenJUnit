package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {
    /*
     metodunun icinde aşağıdaki testi yapalim:
     https://the-internet.herokuapp.com/download adresine gidelim.
     test.txt dosyasını indirelim
     methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/download");

        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[.='test.txt']")).click();


        //methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\User\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}
