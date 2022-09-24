package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Task03 extends TestBaseBeforeAfter {
    /*
     “https://demoqa.com/webtables” sayfasina gidin
     Headers da bulunan department isimlerini yazdirin
     sutunun basligini yazdirin
     Tablodaki tum datalari yazdirin
     Tabloda kac cell (data) oldugunu yazdirin
     Tablodaki satir sayisini yazdirin
     Tablodaki sutun sayisini yazdirin
     Tablodaki 3.kolonu yazdirin
     Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
     Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
     */

    @Test
    public void test01() {

        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin



        //sutunun basligini yazdirin
        WebElement basliklar = driver.findElement(By.xpath("//*[@class='rt-tr']"));
        System.out.println(basliklar.getText());

    }
}
