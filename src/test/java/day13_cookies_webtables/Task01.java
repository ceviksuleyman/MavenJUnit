package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Task01 extends TestBaseBeforeAfter {

    /*
    ● login() metodun oluşturun ve oturum açın.

    ● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresinegidin
      ○ Username:manager
      ○ Password:Manager1!

    ● table() metodu oluşturun
      ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody
      ○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.

    ● printRows() metodu oluşturun //tr
      ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
      ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
      ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    ● printCells() metodu oluşturun//td
      ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
      ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

    ● printColumns() metodu oluşturun
      ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
      ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
      ○ 5.column daki elementleri konsolda yazdırın.
     */

    @Test
    public void test() {

        login();
        table();
        printRows();
        printCells();
        printColumns();
        /*
        table -> thead(basliklar) -> tr(satir) -> th(sutun)
        tbody -> tr(satir) -> td(sutun)
         */
    }



    private void printColumns() {
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.


        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.


        //○ 5.column daki elementleri konsolda yazdırın.
    }
    private void printCells() {
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.


        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

    }

    private void printRows() {
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.



        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.



        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    }

    private void table() {

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody



        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.


    }

    public void login() {

        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.cssSelector("#UserName"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager2!").
                sendKeys(Keys.ENTER).perform();
    }
}
