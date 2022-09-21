package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {

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
