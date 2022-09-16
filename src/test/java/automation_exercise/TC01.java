package automation_exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    String userName = "veliiii can";  // username degistir
    String userMail = "veliiii@gmail.com";  // mail degistir
    String firstName = "veli";
    String lastName = "can";
    WebDriver driver;

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
        if (home.isDisplayed()) System.out.println("Home Test PASSED");
        else System.out.println("Home Test FAIL");


        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement signIn = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        signIn.click();
        Thread.sleep(2000);


        //'Yeni Kullanıcı Kaydı'nı gorunur oldugunu doğrulayın!
        WebElement newUserSignIn = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUserSignIn.isDisplayed()) System.out.println("New User SignIn Test PASSED");
        else System.out.println("New User SignIn Test FAIL");


        // Adı ve e-posta adresini girin
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        name.sendKeys(userName);
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        email.sendKeys(userMail);
        Thread.sleep(2000);


        //'Kaydol' düğmesini tıklayın
        WebElement signUp = driver.findElement(By.xpath("//*[text()='Signup']"));
        signUp.click();
        Thread.sleep(3000);


        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (enterAccount.isDisplayed()) System.out.println("Hesap Bilgilerini Gir PASSED");
        else System.out.println("Hesap Bilgilerini gir FAIL");


        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement title = driver.findElement(By.xpath("//*[@value='Mr']"));
        title.click();
        Thread.sleep(2000);

        String password = "123456789";
        WebElement passwordYaz = driver.findElement(By.id("password"));
        passwordYaz.sendKeys(password);
        Thread.sleep(2000);

        //day
        WebElement day = driver.findElement(By.id("days"));
        day.click();
        Thread.sleep(2000);
        WebElement daySelect = driver.findElement(By.xpath("//*[@value='21']"));
        daySelect.click();
        Thread.sleep(2000);

        //month
        WebElement month = driver.findElement(By.id("months"));
        month.click();
        Thread.sleep(2000);
        WebElement monthSelect = driver.findElement(By.xpath("//*[text()='January']"));
        monthSelect.click();
        Thread.sleep(2000);

        //year  //*[text()='1993']
        WebElement year = driver.findElement(By.id("years"));
        year.click();
        WebElement yearSelect = driver.findElement(By.xpath("//*[text()='1993']"));
        yearSelect.click();
        Thread.sleep(2000);

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        WebElement bulten = driver.findElement(By.id("newsletter"));
        bulten.click();
        Thread.sleep(2000);

        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        WebElement ortaklar = driver.findElement(By.id("optin"));
        ortaklar.click();
        Thread.sleep(2000);



        // Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası

        //name
        WebElement firstNameGir = driver.findElement(By.id("first_name"));
        firstNameGir.sendKeys(firstName);
        Thread.sleep(2000);

        //lastname
        WebElement lastNameGir = driver.findElement(By.id("last_name"));
        lastNameGir.sendKeys(lastName);
        Thread.sleep(2000);

        //company
        String company = "TechProEd";
        WebElement companyGir = driver.findElement(By.id("company"));
        companyGir.sendKeys(company);
        Thread.sleep(2000);

        //adress1
        String address1 = "Turkiye";
        WebElement address1Gir = driver.findElement(By.id("address1"));
        address1Gir.sendKeys(address1);
        Thread.sleep(2000);

        //adress2
        String address2 = "Singapur";
        WebElement address2Gir = driver.findElement(By.id("address2"));
        address2Gir.sendKeys(address2);
        Thread.sleep(2000);

        //Country //*[text()='Singapore']
        WebElement countries = driver.findElement(By.id("country"));
        countries.click();
        WebElement countrySec = driver.findElement(By.xpath("//*[text()='Singapore']"));
        countrySec.click();
        Thread.sleep(2000);

        //state
        String state = "Singapur";
        WebElement stateGir = driver.findElement(By.id("state"));
        stateGir.sendKeys(state);
        Thread.sleep(2000);

        //city
        String city = "Maldiv";
        WebElement cityGir = driver.findElement(By.id("city"));
        cityGir.sendKeys(city);
        Thread.sleep(2000);

        //zipCode
        String zipCode = "64";
        WebElement zipCodeGir = driver.findElement(By.id("zipcode"));
        zipCodeGir.sendKeys(zipCode);
        Thread.sleep(2000);

        //mobil
        String mobile = "03453233443";
        WebElement mobilGir = driver.findElement(By.id("mobile_number"));
        mobilGir.sendKeys(mobile);
        Thread.sleep(2000);


        //'Hesap Oluştur düğmesini' tıklayın    //*[text()='Create Account']
        WebElement createAccount = driver.findElement(By.xpath("//*[text()='Create Account']"));
        createAccount.click();


        //'HESAP OLUŞTURULDU!' görünür    //*[text()='Account Created!']
        WebElement created = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (created.isDisplayed()) System.out.println("Hesap Olusturuldu Test PASSED");
        else System.out.println("Hesap Olusturuldu Test FAIL");


        Thread.sleep(2000);
        //'Devam' düğmesini tıklayın  //*[text()='Continue']
        WebElement contine = driver.findElement(By.xpath("//*[text()='Continue']"));
        contine.click();
        Thread.sleep(3000);


        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        String expectedLoggedIn = driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText();
        System.out.println(expectedLoggedIn);
        WebElement expextedLog = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (expextedLog.isDisplayed()) System.out.println(userName + " Kullanici adi olarak oturum acildi PASSED");
        else System.out.println(userName + " Kullanici adi olarak oturum acildi FAIL");



        //System.out.println(expectedLoggedIn);
        //String[] logged = expectedLoggedIn.split(" ");
        //String isimsoyisim = logged[3] + " " + logged[4];
        //if (isimsoyisim.equals(userName)) System.out.println(userName + " Kullanici adiyla oturum acildi PASS");
        //else System.out.println(userName + " Kullanici adiyla oturum acildi FAIL");


        // 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[.=' Delete Account']")).click();
        Thread.sleep(3000);


        // 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın TODO

    }
}
