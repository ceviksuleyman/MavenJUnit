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

public class TC06 {
    /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
      4. 'Bize Ulaşın' düğmesine tıklayın
      5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
      6. Adı, e-posta adresini, konuyu ve mesajı girin
      7. Dosya yükle
      8. 'Gönder' düğmesini tıklayın
      9. Tamam düğmesine tıklayın
      10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
      11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
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


        //'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();


        //'GET IN TOUCH'un görünür olduğunu doğrulayın
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        System.out.println("Get In Touch Message -> " + getInTouch.getText());
        Assert.assertTrue(getInTouch.isDisplayed());


        //Adı, e-posta adresini, konuyu ve mesajı girin
        driver.findElement(By.xpath("//*[@data-qa='name']")).sendKeys("Ali Can");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='email']")).sendKeys("veliiiiii@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='subject']")).sendKeys("TEST");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='message']")).sendKeys("Hayat dedigin bir cift bacak,gidebildigi  yol kadar");
        Thread.sleep(1000);

        // Dosya yükle
        driver.findElement(By.xpath("//*[@name='upload_file']")).
                sendKeys("C:\\Users\\User\\IdeaProjects\\com.JUnit\\src\\test\\java\\automation_exercise\\redCar.png");

        //'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();
        Thread.sleep(1000);

        //Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();


        //Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement success = driver.findElement(By.xpath("//*[text()='Success! Your details have been submitted successfully.']"));
        System.out.println("success massage -> " + success.getText());
        Assert.assertTrue(success.isDisplayed());
        Thread.sleep(2000);

        //'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[text()=' Home']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
