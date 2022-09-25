package day14_readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

        // -Dosya yolunu bir String degiskene atayalim
        String dosya = "src/resources/ulkeler02.xlsx";


        // -FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosya);


        // -Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // -WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);


        // -sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatir = wb.getSheet("Sayfa2").getLastRowNum(); // tablodaki son satir
        System.out.println(sonSatir+1);

    }
}
