package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        1 https://www.amazon.com/ sayfasinagidelim
        2 arama kutusunu locateedelim
        3 “Samsung headphones” ile aramayapalim
        4 Bulunan sonuc sayisiniyazdiralim
        5 Ilk urunutiklayalim
        6 Sayfadaki tum basliklariyazdiralim
         */

        // 1
        driver.get("https://www.amazon.com");


        // 2
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);


        // 3
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);


        // 4
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        String[] sonucArr = sonucSayisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucArr));

        Arrays.stream(sonucArr).limit(3).skip(2).forEach(System.out::println);


        // 5
        WebElement ilkUrun = driver.findElement(By.cssSelector("img[class='s-image']"));

        ilkUrun.click();

        // 6
        String title = driver.getTitle();
        System.out.println(title);

        //kapat
        driver.close();

    }
}
