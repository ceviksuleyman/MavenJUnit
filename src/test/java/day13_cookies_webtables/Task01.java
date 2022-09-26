package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Task01 extends TestBaseBeforeAfter {

    /*
    ● login() metodun oluşturun ve oturum açın.

    ● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
       Username : manager
       Password : Manager1!

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
        List<WebElement> toplamSutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("\n\nBody Toplam Sutun Sayisi -> " + toplamSutunSayisi.size());


        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.


        //○ 5.column daki elementleri konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5][1]"));
        System.out.println("\n5.SUTUNDAKI DATALAR");
        column5.forEach(t -> System.out.println(t.getText()));

    }


    private void printCells() {
        // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cell = driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println("\nBody'de Bulunan Hucre Sayisi -> " + cell.size());


        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<String> hucreButun = List.of(driver.findElement(By.xpath("//tbody")).getText().split(","));
        System.out.println("\nCell'de Butun Datalar");
        hucreButun.forEach(t -> System.out.print(t + " "));

    }

    private void printRows() {
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("\nTabloda Bulunan Satir Sayisi -> " + satirSayisi.size());


        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("\nSATIRLAR");
        satirSayisi.forEach(t -> System.out.println(t.getText()));


        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement row4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("\n4.Satirdaki Datalar -> " + row4.getText());

    }

    private void table() {

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//tr//th"));
        System.out.println("\nSUTUN SAYISI -> " + sutunSayisi.size());


        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("\nTABLO BASLIKLAR -> " + basliklar.getText());


        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("\nTABLODAKI DATALAR");
        System.out.println(body.getText());

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
