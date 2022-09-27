package apractice.practice03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01_GMIBankLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));


        // 1 - https://www.gmibank.com adresine gidin
        driver.get("https://www.gmibank.com/");



        // 2 - sign in butonuna tikla
        driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.cssSelector("#login-item")).click();



        // 3 - Kullanici bilgilerini gir
        driver.findElement(By.cssSelector("*[name='username']")).sendKeys("Batch81");
        driver.findElement(By.cssSelector("*[name='password']")).sendKeys("Batch81+", Keys.ENTER);
        //driver.findElement(By.cssSelector("*[type='submit']")).click();

        Thread.sleep(4000);

        driver.quit();
        /*
        ElementNotVisibleException: Selenium Web sayfasında görünür olmayan bir elementi bulmaya çalıştığında karşılaşılan bir exception türüdür.

        NoAlertPresentException: Olmayan bir uyarı/pop-up şeklindeki diyalog üzerinde işlem yapılmaya çalışıldığında karşılaşılır.

        NoSuchWindowException: Yeni bir pencereye geçmeye çalışıldığında alınan exception türüdür.

        NoSuchElementException: Sayfada bulunmayan bir elemente erişim sağlanmaya çalışıldığında karşılaşılır.

        WebDriverException: Herhangi bir kod bloğu Selenium Web Driver’ı çalıştıramadığında oluşan exception türüdür.


        above
        below
        toLeftOf
        toRightOf
        near
         */
    }
}
