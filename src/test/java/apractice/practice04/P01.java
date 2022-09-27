package apractice.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {

        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement emojiIframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(emojiIframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        // tüm hayvan emojilerine tıklayın
        List<WebElement> emojiList = driver.findElements(By.cssSelector(".mdl-tabs__panel.is-active>:nth-child(1)>img"));
        emojiList.forEach(WebElement::click);

        // tüm hayvan emojilerine tıklayın  Hocadan
        //List<WebElement> animals = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        //for (WebElement w : animals) {
        //    w.click();
        //}
        //animals.forEach(t -> t.click());

        driver.switchTo().defaultContent();

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> formList = driver.findElements(By.cssSelector("input[class=mdl-textfield__input]"));

        // Bu listi kullanarak her bir webelementi kolayca form listinde bulunan webelementlerimize gonderebilecegiz
        List<String> texts = new ArrayList<>(Arrays.asList("hayat", "dedigin", "bir", "cift", "bacak", "ve", "gidebildigi", "yol", "kadar", "!!!!>?>?>", "???????"));

        for (int i = 0; i < formList.size(); i++) {
            formList.get(i).sendKeys(texts.get(i)); // text'leri sirayla formdaki webelement'lere gonderir
        }


        // apply butonuna tıklayın
        driver.findElement(By.cssSelector("button[id=send]")).click();
    }
}
