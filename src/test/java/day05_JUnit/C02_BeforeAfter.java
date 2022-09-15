package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    @Before   // @Before notasyonu her testten once calisir.
    public void setUp() {  // @Before genelde setUp ismi kullanilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After  // @After notasyonu her testten sonra calisir.
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {

        // 1 defa before method'u calisir
        driver.get("https://www.amazon.com");
        // 1 defa da after method'u calisir
    }

    @Test
    public void test02() {

        driver.get("https://www.youtube.com");
    }

    @Test
    public void test03() {

        driver.get("https://www.google.com");
    }

}
