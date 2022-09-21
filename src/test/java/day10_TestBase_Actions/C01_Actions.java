package day10_TestBase_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        // amazon.com'a git
        driver.get("https://www.amazon.com");

        // Account menusunden create a list linkine tikla
        // parent class'tan actions objesi inherit

        Actions actions = new Actions(driver); // Actions class'indan bir obje olusturduk.

        WebElement account = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(account).perform(); //mouse ile uzerinde bekle

        driver.findElement(By.xpath("//*[.='Create a List']")).click();

        /*
        Bir web bir webelemtin mouse ile acilan bir webelementine ulasmak istersek Actions class'indan olusturdugumuz
        objeyi actions.moveToElement() method'unu kullanmamiz gerekir.Aksi halde html kodlari arasinda webelementi bulur
        fakat ulasamadigi icin ElemenNotInteractableException: element not interactable  firlatir.
         */
    }
}
