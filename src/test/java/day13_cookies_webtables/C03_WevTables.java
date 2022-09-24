package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;

public class C03_WevTables extends C02_WebTables {

    /*
      Bir onceki class'daki adres'e gidelim. login() method'unu kullanarak sayfaya giris yapalim
      input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i yazdiralim.
      int satir = 3;
      int sutun = 4;
         */

    @Test
    public void test() {

        login();

        int satir = 3;
        int sutun = 4;
        System.out.println(driver.findElement(By.xpath("//tbody//tr[3]//td[4]")).getText());
    }
}
