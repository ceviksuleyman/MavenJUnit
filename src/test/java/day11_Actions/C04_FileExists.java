package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    /*
    ● Selenium ile windows uygulamalarını test edemiyoruz. Ama test etmek için JAVA kullanabiliriz.
    ● Bilgisayarımızda bir dosya olupolmadığını(exist)  kontrol etmek için Java'yı kullanabiliriz
      ○ System.getProperty ( "user.dir"); icindebulunulanklasörün yolunu (Path) verir
      ○ System.getProperty ( "user.home");  bilgisayarimizda bulunan user klasörünü verir
      ○ Files.exists (Paths.get (filePath)); Bilgisayarınızda  dosyanın olup olmadığını kontrol eder
    ● İndirilen bir dosyanın indirme klasörümüzde olup olmadığını kontrol etmek için bu Java konseptini kullanabiliriz
     */

    @Test
    public void test01() {
        //su an icinde gecerli bulundugum dosya yolunu verir
        System.out.println(System.getProperty("user.dir")); //C:\Users\cevik\IdeaProjects\com.JUnit

        // Gecerli kullanicinin ana dizini
        System.out.println(System.getProperty("user.home")); // C:\Users\cevik


        String dosyaYolu = "C:\\Users\\cevik\\OneDrive\\Masaüstü\\text.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir websitesinden indirdigimiz ya da windows icinde olusturdugumuz dosyanin indigini ya da orda oldugunu
        test edebilmem icin o dosyanin uzerine Shift tusuna basili olarak sag click yapip dosya yolunu kopyalayip
        bir String degiskene atariz ve dosyayi dogrulamak icin Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        bu method'u kullaniriz.
         */

    }
}
