package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Task {
     /*
    - Bir Class olusturalimYanlisEmailTesti
    - http://automationpractice.com/index.php sayfasina gidelim
    - Sign in butonuna basalim
    - Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
      “Invalid email address” uyarisi ciktigini testedelim
     */

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        // Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
        Thread.sleep(2000);


        // Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email']"));
        emailBox.sendKeys("ali.com", Keys.ENTER);


        //“Invalid email address” uyarisi ciktigini test edelim
        WebElement invalidEmail = driver.findElement(By.xpath("//*[.='Invalid email address.']"));
        Assert.assertTrue(invalidEmail.isDisplayed());

    }

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
