package day16_getScreenshot_JSExecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_JSExecutors extends TestBaseBeforeAfter {

    @Test
    public void test() {


        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim //*[.='Careers']

        WebElement careers = driver.findElement(By.linkText("Careers"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);", careers);


        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click()", careers);
    }
}
