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

public class TC04 {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
     5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
     6. Doğru e-posta adresini ve şifreyi girin
     7. 'Giriş' düğmesini tıklayın
     8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
     9. 'Çıkış' düğmesini tıklayın
     10. Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
     */

    WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());


        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        Thread.sleep(1000);


        // 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Login to your account']")).isDisplayed());
        String loginToYA = driver.findElement(By.xpath("//*[.='Login to your account']")).getText();
        System.out.println("Gorunen Ifade -> " + loginToYA);
        Thread.sleep(1000);


        //Doğru e-posta adresini ve şifreyi girin
        String userMail = "veliiiiii@gmail.com";
        String userPassword = "123456789";
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys(userMail);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys(userPassword);
        Thread.sleep(1000);


        //'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();


        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement logged = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        Thread.sleep(1000);


        //'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/logout']")).click();


        //Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath(" //*[.=' Signup / Login']")).isDisplayed());
        System.out.println("Giris Sayfasi -> "+driver.findElement(By.xpath(" //*[.=' Signup / Login']")).getText());

    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
}
