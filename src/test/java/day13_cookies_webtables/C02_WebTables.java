package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

      /*
    login() metodun oluşturun ve oturum açın.
    https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
       Username : manager
       Password : Manager1!
    table() metodu oluşturun
         Tüm table body’sinin boyutunu(sutun sayisi) bulun.
         Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    printRows() metodu oluşturun //tr
         table body’sinde bulunan toplam satir(row) sayısını bulun.
         Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
         4.satirdaki(row) elementleri konsolda yazdırın.
     */


    @Test
    public void test01() throws InterruptedException {

        login();
        table();
        printRows();
    }

    public void printRows() {

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("\nTablodaki Satir Sayisi -> " + satirList.size());


        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("\nTablodaki satilar");
        satirList.forEach(t -> System.out.println(t.getText()));


        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("\nTablo 4.satir -> " +
                driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }

    public void table() throws InterruptedException {

        /*
        table -> thead(basliklar) -> tr(satir) -> th(sutun)
        tbody -> tr(satir) -> td(sutun)
        Tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag'i bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr>(row) tag'i vardir ve basliktaki sutunlara
        yani hucrelere(cell) de <th> tag'i ile ulasilir.
        Basligin altintaki tablodaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
        sutunlara yani hucrelere <td> tag'i ile ulasiriz.
         */


        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("\nSutun Sayisi -> " + sutunSayi.size());


        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("\nBASLIKLAR\n" + basliklar.getText());

        Thread.sleep(5000);
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("\nBODY\n" + body.getText());
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
