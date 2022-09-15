package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03 {
    /*
    1.“https://www.saucedemo.com”Adresine gidin
    2.Username kutusuna “standard_user” yazdirin
    3.Password kutusuna “secret_sauce” yazdirin
    4.Login tusunabasin
    5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6.Add to Cart butonuna basin
    7.Alisveris sepetine tiklayin
    8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9.Sayfayi kapatin
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();



        // “https://www.saucedemo.com”  Adresine gidin
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);



        //Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user", Keys.ENTER);
        Thread.sleep(2000);



        //Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce", Keys.ENTER);
        Thread.sleep(2000);



        //Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);



        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String urunIsmi = driver.findElement(By.id("item_4_title_link")).getText();
        System.out.println("Urun ismi -> " + urunIsmi);

        driver.findElement(By.id("item_4_title_link")).click(); // urun sayfasina git
        Thread.sleep(2000);



        // Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[.='Add to cart']")).click();
        Thread.sleep(2000);



        //Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(2000);


        // Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet = driver.findElement(By.xpath("//*[@id='contents_wrapper']"));

        if (sepet.getText().contains(urunIsmi)) System.out.println("Urun Sepete Eklendi PASSED");
        else System.out.println("Urun Sepete Eklendi FAIL");


        //kapat
        driver.close();
    }
}
