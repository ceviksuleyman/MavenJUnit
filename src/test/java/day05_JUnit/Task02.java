package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    /*
    -https://www.facebook.com adresinegidin
    - Cookies’i kabuledin
    -“Create an Account” button’una basin
    -“radio buttons” elementlerini locate edin
    -Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

        //“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[.='Yeni Hesap Oluştur']")).click();
        Thread.sleep(2000);

        //“radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.cssSelector("input[value='1']"));
        WebElement male = driver.findElement(By.cssSelector("input[value='2']"));
        WebElement ozel = driver.findElement(By.cssSelector("input[value='-1']"));
        Thread.sleep(2000);
        if (!female.isSelected()) female.click();
        Thread.sleep(2000);
        if (!male.isSelected()) male.click();
        Thread.sleep(2000);
        if (!ozel.isSelected()) ozel.click();
        Thread.sleep(2000);
    }

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
