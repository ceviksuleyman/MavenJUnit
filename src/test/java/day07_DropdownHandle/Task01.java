package day07_DropdownHandle;

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

public class Task01 {
    /*
     1.http://zero.webappsecurity.com/ Adresine gidin
     2.Sign in butonuna basin
     3.Login kutusuna “username” yazin
     4.Password kutusuna “password.” yazin
     5.Sign in tusuna basin
     6.Pay Bills sayfasina gidin
     7.“Purchase Foreign Currency” tusuna basin
     8.“Currency” drop down menusunden Eurozone’u secin
     9.“amount” kutusuna bir sayi girin
     0.“US Dollars” in secilmedigini test edin
     11.“Selected currency” butonunu secin
     12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
     13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
      */
    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1000);


        // Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        Thread.sleep(1000);


        //Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        Thread.sleep(1000);


        //Sign in tusuna basin
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.navigate().to("http://zero.webappsecurity.com/");
        Thread.sleep(1000);


        // Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();


        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
        Thread.sleep(1000);


        //“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        select = new Select(ddm);
        select.selectByIndex(6);
        Thread.sleep(2000);


        //“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("100");
        Thread.sleep(1000);


        //“US Dollars” in secilmedigini test edin
        WebElement usd = driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
        Assert.assertFalse(usd.isSelected());


        //“Selected currency” butonunu secin
        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();
        Thread.sleep(1000);


        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();


        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement message = driver.findElement(By.xpath("//*[@id='alert_content']"));
        System.out.println("Mesaj -> " + message.getText());
        Assert.assertTrue(message.isDisplayed());
    }
}
