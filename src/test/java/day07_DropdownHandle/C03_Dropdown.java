package day07_DropdownHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    /*
   Bir class oluşturun: DropDown
   https://the-internet.herokuapp.com/dropdown adresine gidin.
   Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
   Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   Tüm dropdown değerleri(value) yazdırın
   Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
   */
    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));

        select = new Select(ddm);

        select.selectByIndex(1);
        Thread.sleep(2000);


        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        Thread.sleep(2000);


        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("----");


        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> drops = select.getOptions();
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }
        System.out.println("----");


        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int actualDdSayi = select.getOptions().size();
        System.out.println("dropdown Sayi -> " + actualDdSayi);

        if (actualDdSayi == 4) System.out.println("True");
        else System.out.println("False");
    }
}
