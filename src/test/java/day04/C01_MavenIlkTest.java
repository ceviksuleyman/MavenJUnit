package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        // 1 https://www.amazon.com/ sayfasina git
        driver.get("https://www.amazon.com");



        // 2 arama kutusunu locate et
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);



        // 3 “Samsung headphones” ile arama yap
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);



        // 4 Bulunan sonuc sayisini yazdir
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] sonucArr = sonucSayisi.getText().split(" ");
        String sonuc = sonucArr[2];
        System.out.println("\"Samsung headphones\" arama sonucu -> " + sonuc);
        Arrays.stream(sonucArr).limit(3).skip(2).forEach(System.out::println);



        // 5 Ilk urunu tikla
        WebElement ilkUrun = driver.findElement(By.cssSelector("img[class='s-image']"));
        ilkUrun.click();



        // 6 Sayfadaki tum basliklari yazdir
        WebElement titles = driver.findElement(By.xpath("//h1"));
        System.out.println("Baslik -> " + titles.getText());
        WebElement titless = driver.findElement(By.xpath("//h2"));
        System.out.println("Baslik -> " + titless.getText());


        //kapat
        driver.close();

    }
}
