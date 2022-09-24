package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends C02_WebTables {

    /*
        Bir onceki class'daki adres'e gidelim. login() method'unu kullanarak sayfaya giris yapalim
        input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i yazdiralim.
        Price basligindaki tum numaralari yazdirin
        int satir = 3;
        int sutun = 4;
         */

    @Test
    public void test() {
        login();
        int satir = 3;
        int sutun = 4;
        WebElement cell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(cell.getText());

        //tbody//td[6]
        List<WebElement> priceList = driver.findElements(By.xpath("//tbody//tr//td[6]"));

        for (WebElement w : priceList) {

            System.out.println(w.getText());
        }
    }
}
