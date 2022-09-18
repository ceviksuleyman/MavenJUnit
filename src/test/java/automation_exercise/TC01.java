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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TC01 {
      /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın(Ana sayfanın başarıyla görüldüğünü doğrulayın)
      4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
      5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
      6. Adı ve e-posta adresini girin
      7. 'Kaydol' düğmesini tıklayın
      8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
      9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
      10. 'Bültenimize kaydolun!' onay kutusunu seçin.
      11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
      12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
      13. 'Hesap Oluştur düğmesini' tıklayın
      14. 'HESAP OLUŞTURULDU!' görünür
      15. 'Devam' düğmesini tıklayın
      16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
      17. 'Hesabı Sil' düğmesini tıklayın
      18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
       */

    String userName = "velii can";  // username degistir
    String userMail = "veliii2@gmail.com";  // mail degistir
    String firstName = "veli";
    String lastName = "can";
    WebDriver driver;
    Select select;

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

    @Test
    public void tc01() throws InterruptedException {

        //'http://automationexercise.com' url'sine git
        driver.get("http://www.automationexercise.com");
        Thread.sleep(3000);


        //Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın
        WebElement home = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(home.isDisplayed());


        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        Thread.sleep(2000);


        //'Yeni Kullanıcı Kaydı'nı gorunur oldugunu doğrulayın!
        WebElement newUserSignIn = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignIn.isDisplayed());


        // Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys(userName);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(userMail);
        Thread.sleep(2000);


        //'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        Thread.sleep(3000);


        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccount.isDisplayed());


        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("//*[@value='Mr']")).click();
        Thread.sleep(2000);

        //password
        String password = "123456789";
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);

        //day
        WebElement day = driver.findElement(By.id("days"));
        select = new Select(day);
        select.selectByIndex(21);
        Thread.sleep(2000);

        //month
        WebElement month = driver.findElement(By.id("months"));
        select = new Select(month);
        select.selectByIndex(1);
        Thread.sleep(2000);

        //year  //*[text()='1993']
        WebElement year = driver.findElement(By.id("years"));
        select = new Select(year);
        select.selectByValue("1993");
        Thread.sleep(2000);

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.id("newsletter")).click();
        Thread.sleep(2000);

        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.id("optin")).click();
        Thread.sleep(2000);


        // Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası

        //name
        driver.findElement(By.id("first_name")).sendKeys(firstName);
        Thread.sleep(2000);

        //lastname
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        Thread.sleep(2000);

        //company
        String company = "TechProEd";
        driver.findElement(By.id("company")).sendKeys(company);
        Thread.sleep(2000);

        //adress1
        String address1 = "Turkiye";
        driver.findElement(By.id("address1")).sendKeys(address1);
        Thread.sleep(2000);

        //adress2
        String address2 = "Singapur";
        driver.findElement(By.id("address2")).sendKeys(address2);
        Thread.sleep(2000);

        //Country //*[text()='Singapore']
        WebElement countries = driver.findElement(By.id("country"));
        select = new Select(countries);
        select.selectByIndex(6);
        Thread.sleep(2000);

        //state
        String state = "Singapur";
        driver.findElement(By.id("state")).sendKeys(state);
        Thread.sleep(2000);

        //city
        String city = "Maldiv";
        driver.findElement(By.id("city")).sendKeys(city);
        Thread.sleep(2000);

        //zipCode
        String zipCode = "64";
        driver.findElement(By.id("zipcode")).sendKeys(zipCode);
        Thread.sleep(2000);


        //mobil
        String mobile = "03453233443";
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
        Thread.sleep(2000);


        //'Hesap Oluştur düğmesini' tıklayın    //*[text()='Create Account']
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();


        //'HESAP OLUŞTURULDU!' görünür    //*[text()='Account Created!']
        WebElement created = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(created.isDisplayed());
        Thread.sleep(2000);


        //'Devam' düğmesini tıklayın  //*[text()='Continue']
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(2000);


        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement expextedLog = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText());
        Assert.assertTrue(expextedLog.isDisplayed());


        // 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[.=' Delete Account']")).click();
        Thread.sleep(2000);


        // 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın TODO
        WebElement deleted = driver.findElement(By.xpath("//*[@class='wrapper']"));
        Assert.assertTrue(deleted.isDisplayed());

    }
}
