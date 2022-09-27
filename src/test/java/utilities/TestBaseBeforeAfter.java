package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeAfter {


    protected WebDriver driver;
    protected Actions actions;
    protected Select select;
    protected String tarih1;
    protected String tarih2;

    protected DateTimeFormatter formater1, formatter2;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);

        LocalDateTime date = LocalDateTime.now();
        formater1 = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        tarih1 = date.format(formater1);
        tarih2 = date.format(formatter2);
    }

    @After
    public void tearDown() {

        //driver.quit();
    }
}
