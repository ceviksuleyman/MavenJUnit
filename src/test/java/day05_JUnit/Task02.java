package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    /*
    -https://www.facebook.com adresinegidin
    -Cookies’i kabuledin
    -“Create an Account” button’unabasin
    -“radio buttons” elementlerini locateedin
    -Secili degilse cinsiyet butonundan size uygun olanisecin
     */
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void fbTest(){
        //-https://www.facebook.com adresinegidin
        driver.get("https://www.facebook.com");
    }

}
