package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    ● Bir class olusturun:Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun:acceptAlert01.
    butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert”
    oldugunu test edin.
    ● Bir metod olusturun:dismissAlert02.
    butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
    allert uzerindeki mesaji yazdir
    ● Bir metod olusturun:sendKeysAlert03.
    butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında
    isminizin görüntülendiğini doğrulayın.
     */
    static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }


    @Test
    public void acceptAlert01() throws InterruptedException {  // simple alert
        /*
        Bir metod olusturun : acceptAlert01.
        butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert”
        oldugunu test edin.
         */
        /*
         Simple ALert => Bu basit alert ekranda bazi bilgiler veya uyarilar goruntuler.
         Ok(Tamam) veya istenilen neyse secerek kapatilir
         */

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement message = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMessage = message.getText();
        System.out.println("1. button Result message -> " + actualMessage);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("----");
    }


    @Test
    public void dismissAlert02() throws InterruptedException { // Confirmation Alert
        /*
        Bir metod olusturun : dismissAlert02
        butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        allert uzerindeki mesaji yazdir
         */
         /*
         Confirmation Alert => Bu onay uyarisi bir tur islem yapma izni ister. Alert  onaylaniyorsa OK,
         onaylanmiyorsa Cancel butonuna basilir.
         */

        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        System.out.println("2. button JS Confirm alert message -> " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        WebElement message = driver.findElement(By.xpath("//*[@id='result']"));
        Thread.sleep(3000);
        String actualMessage = message.getText();
        System.out.println("Result message -> " + actualMessage);
        String unexpectedMess = "successfuly";
        Assert.assertFalse(actualMessage.contains(unexpectedMess));
        System.out.println("----");
    }


    @Test
    public void sendKeysAlert03() throws InterruptedException { // prompt Alert
        /*
        Bir metod olusturun : sendKeysAlert03.
        butona tiklayin, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tiklayin ve result mesajinda
        isminizin goruntulendigini dogrulayin.
         */
        /*
        Prompt Alert => Bu Prompt Uyarisi kullanicidan bazi girdilerin girilmesini ister ve
        selenium webdriver metni sendkeys ("input....") kullanarak girebilir.
        */

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        System.out.println("3. button JS prompt Alert mesaj -> " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("cevik");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        String actualResult = result.getText();
        System.out.println("Result JS prompt -> " + actualResult);
        String expectedResult = "cevik";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("----");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
