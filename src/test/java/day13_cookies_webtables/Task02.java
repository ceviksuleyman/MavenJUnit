package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;


public class Task02 extends TestBaseBeforeAfter {
    /*
    1.Bir metod oluşturun : printData(int row, int column);
      a.Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu buhücredeki(cell) veriyi yazdırmalıdır.
    2.Baska bir Test metodu oluşturun: printDataTest();
      a.Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
      b.Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
      c.yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */

    /*
     1.Bir metod oluşturun : printData(int row, intcolumn);
       a.Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodubuhücredeki(cell) veriyi yazdırmalıdır.
     2.Baska bir Test metodu oluşturun: printDataTest();
       a.Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
       b.Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
       c.yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
      */
    @Test
    public void printDataTest() {

        login();
        printData(3, 4);
    }

    public void printData(int row, int column) {

        System.out.println(driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]")).getText());
    }

    public void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.cssSelector("#UserName"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();
    }
}
