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

public class TC05 {
    /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
      4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
      5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
      6. Adı ve kayıtlı e-posta adresini girin
      7. 'Kaydol' düğmesini tıklayın
      8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
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


        // 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.=' Signup / Login']")).click();

        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement newUser = driver.findElement(By.xpath("//*[.='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());
        Thread.sleep(1000);

        //Adı ve kayıtlı e-posta adresini girin
        String name = "Veli Can";
        String userMail = "veliiiiii@gmail.com";
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(userMail);

        //'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        Thread.sleep(1000);

        //'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        WebElement alreadyEmailAddress = driver.findElement(By.xpath("//*[.='Email Address already exist!']"));
        Assert.assertTrue(alreadyEmailAddress.isDisplayed());
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
