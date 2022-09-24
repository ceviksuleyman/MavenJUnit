package day13_cookies_webtables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
     /*
    1 - Amazon anasayfaya gidin
    2 - tum cookie’leri listeleyin
    3 - Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4 - ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5 - ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6 - eklediginiz cookie’nin sayfaya eklendigini test edin
    7 - ismi skin olan cookie’yi silin ve silindigini test edin
    8 - tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void test01() {

        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        //tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        int count = 1;
        for (Cookie w : cookies) {
            System.out.println(count + ". cockie -> " + w);
            System.out.println(count + ". name -> " + w.getName());
            System.out.println(count + ". value -> " + w.getValue());
            count++;
        }

        //Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("toplam cookie -> " + cookies.size());
        Assert.assertTrue(5 < cookies.size());


        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : cookies) {

            if (w.getName().equals("i18n-prefs")) Assert.assertEquals("USD", w.getValue());
        }


        System.out.println("------------------------------------------------------------------");
        //ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie); // ekleme yaptiktan sonra
        cookies = driver.manage().getCookies(); // set'i guncellemek icin tekrar assign
        count = 1;
        for (Cookie w : cookies) {
            System.out.println(count + ". cookie -> " + w);
            System.out.println(count + ". name -> " + w.getName());
            System.out.println(count + ". value -> " + w.getValue());
            count++;
        }


        //eklediginiz cookie’nin sayfaya eklendigini test edin
        for (Cookie w : cookies) {
            if (w.getName().equals("en sevdigim cookie")) Assert.assertEquals("cikolatali", w.getValue());
        }
        Assert.assertTrue(cookies.contains(yeniCookie));


        System.out.println("--------------------------------------------------------------------");
        //ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();
        count = 1;
        for (Cookie w : cookies) {
            System.out.println(count + ". cookie -> " + w);
            System.out.println(count + ". name -> " + w.getName());
            System.out.println(count + ". value -> " + w.getValue());
            count++;
        }
        Cookie isim = driver.manage().getCookieNamed("skin"); // once cagirdik Cookie atadik
        Assert.assertFalse(cookies.contains(isim)); // sonra silindigini test ettik


        //tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookies = driver.manage().getCookies();

        Assert.assertTrue(cookies.isEmpty());
    }
}
