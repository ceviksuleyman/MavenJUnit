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

public class TC03 {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
     5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
     6. Yanlış e-posta adresi ve şifre girin
     7. 'Giriş' düğmesini tıklayın
     8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
     */
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());


        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        Thread.sleep(1000);


        // 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Login to your account']")).isDisplayed());
        String loginToYA = driver.findElement(By.xpath("//*[.='Login to your account']")).getText();
        System.out.println("Gorunen Ifade -> " + loginToYA);


        // Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("aliveli@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12343");
        Thread.sleep(1000);


        //'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();


        //'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        WebElement girisHatasi = driver.findElement(By.xpath("//*[.='Your email or password is incorrect!']"));
        System.out.println("hata mesaji -> " + girisHatasi.getText());
        Assert.assertTrue(girisHatasi.isDisplayed());
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
        driver.close();
    }
}
