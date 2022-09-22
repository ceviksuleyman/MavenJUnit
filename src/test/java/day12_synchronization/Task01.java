package day12_synchronization;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class Task01 extends TestBaseBeforeAfter {
    /*
   "http://webdriveruniversity.com/Actions" sayfasina gidin
   "Hover over Me First" kutusunun ustune gelin
   "Link 1" e tiklayin
   Popup mesajini yazdirin
   Popup'i tamam diyerek kapatin
   "Click and hold" kutusuna basili tutun
   "Click and hold" kutusunda cikan yaziyi yazdirin
   "Double click me" butonunu cift tiklayin
   */
    @Test
    public void test01() {

        driver.get("http://webdriveruniversity.com/Actions");
    }
}
