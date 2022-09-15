package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    /*
     * https://www.google.com/adresinegidin
     * cookies uyarisini kabul ederek kapatin
     * Sayfa basliginin “Google” ifadesi icerdigini testedin
     * Arama cubuguna “Nutella” yazip aratin
     * Bulunan sonuc sayisini yazdirin
     * sonuc sayisinin 10milyon’dan fazla oldugunu test edin
     * Sayfayi kapatin
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();


        // https://www.google.com git
        driver.get("https://www.google.com");
        Thread.sleep(3000);


        // cookies uyarisini kabul ederek kapatin ?


        // Sayfa basliginin “Google” ifadesi icerdigini testedin
        String title = driver.getTitle();
        System.out.println("Sayfa Basligi -> " + title);
        if (title.contains("Google")) System.out.println("Sayfa Basligi Test PASSED");
        else System.out.println("Sayfa Baslisi Test FAIL");


        // Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);
        Thread.sleep(3000);


        // Bulunan sonuc sayisini yazdirin
        WebElement aramaSonuc = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(aramaSonuc.getText());
        String[] sonucArr = aramaSonuc.getText().split(" ");
        System.out.println("Nutella Arama Sonucu -> " + sonucArr[1]);


        //sonuc sayisinin 10milyon’dan fazla oldugunu test edin
        int sonucInt = Integer.parseInt(sonucArr[1].replaceAll("\\D", ""));
        System.out.println(sonucInt);

        if (sonucInt > 10000000) System.out.println("Sonuc 10 milyondan fazla PASSED");
        else System.out.println("Sonuc 10 milyondan fazla FAIL");


        //kapat
        driver.close();

    }
}
