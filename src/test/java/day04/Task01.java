package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {
    /*
    1.http://zero.webappsecurity.comsayfasinagidin
    2.Signin buttonuna tiklayin
    3.Login alanine  “username”yazdirin
    4.Password alanine “password”yazdirin
    5.Sign in buttonunatiklayin
    6.Pay Bills sayfasinagidin
    7.amount kismina yatirmak istediginiz herhangi bir miktariyazin
    8.tarih kismina “2020-09-10”yazdirin
    9.Pay buttonunatiklayin
    10.“The payment was successfully submitted.” mesajinin ciktigini controledin
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();

        //http://zero.webappsecurity.com sayfasina git
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        //Signin buttonuna tiklayin
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signInButton.click();
        Thread.sleep(2000);

        //Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.cssSelector("input[id='user_login']"));
        login.sendKeys("username");
        Thread.sleep(2000);

        //Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.cssSelector("#user_password"));
        password.sendKeys("password");
        Thread.sleep(2000);

        //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@name='submit']")).click();


        //kapat
        //driver.close();
    }
}
