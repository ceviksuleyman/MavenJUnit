package automation_exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC07 {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Test Vakaları' düğmesine tıklayın
     5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        // http://automationexercise.com
        driver.get("http://automationexercise.com");
        Thread.sleep(1000);


        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement home = driver.findElement(By.xpath("//*[.=' Home']"));
        Assert.assertTrue(home.isDisplayed());


        //'Test Vakaları' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/test_cases']")).click();
        Thread.sleep(1000);


        //Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='form']")).isDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
}
