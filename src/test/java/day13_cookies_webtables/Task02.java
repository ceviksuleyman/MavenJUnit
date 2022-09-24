package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;


public class Task02 extends C02_WebTables {
    /*
    1.Bir metod oluşturun : printData(int row, int column);
      a.Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu buhücredeki(cell) veriyi yazdırmalıdır.
    2.Baska bir Test metodu oluşturun: printDataTest();
      a.Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
      b.Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
      c.yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */

    @Test
    public void printDataTest() {

        printData(3, 5);
    }

    public void printData(int row, int column) {

        login();
        System.out.println(driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]")).getText());
    }
}
