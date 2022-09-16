package automation_exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC02 {
    /*
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' url'sine gidin
    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
    6. Doğru e-posta adresini ve şifreyi girin
    7. 'Giriş' düğmesini tıklayın
    8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
    9. 'Hesabı Sil' düğmesini tıklayın
    10. 'HESAP SİLİNDİ!' görünür
     */
    WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement home = driver.findElement(By.xpath("//*[.=' Home']"));
        Assert.assertTrue(home.isDisplayed());
        Thread.sleep(2000);

        // 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        Thread.sleep(2000);

        // 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement loginToYourAccount = driver.findElement(By.xpath("//*[.='Login to your account']"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());

        // Doğru e-posta adresini ve şifreyi girin
        WebElement emailBox = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@data-qa='login-password']"));

        String userMail = "veliiiiii@gmail.com";
        String userPassword = "123456789";

        emailBox.sendKeys(userMail);
        Thread.sleep(1000);
        passwordBox.sendKeys(userPassword);
        Thread.sleep(1000);

        //'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement logged = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());


        //'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        Thread.sleep(2000);

        //'HESAP SİLİNDİ!' görünür
        WebElement deleted = driver.findElement(By.xpath("//*[@class='wrapper']"));
        Assert.assertTrue(deleted.isDisplayed());
    }


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() {

        driver.close();
    }
}
