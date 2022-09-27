package day14_readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

        // -Dosya yolunu bir String degiskene atayalim
        String dosyaYol = "src/resources/ulkeler02.xlsx";


        // -FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYol);


        // -Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // -WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);


        // -sayfa 2'ye gidip satir sayisinin 20, kullanilan satir sayisinin ise 9 oldugunu test edin
        int sonSatir = wb.getSheet("Sayfa2").getLastRowNum(); // son satir
        System.out.println(sonSatir+1);

        int expectedLastRow = 20;
        Assert.assertEquals(expectedLastRow, sonSatir + 1);

        int kullanilanSatir = wb.getSheet("Sayfa2").getPhysicalNumberOfRows(); //icinde veri olan satir sayisini ver
        System.out.println("Kullanilan satir -> " + kullanilanSatir);


    }

}
