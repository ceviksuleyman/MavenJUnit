package day14_readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcel01() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";


        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // olusturmus oldugumuz dosyayi sistemde isleme alir.


        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);
        // wb objesi ile fis objesi ile akisa aldigimiz dosyamiza bir ecxel dosyasi create ettik


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)

        String actualData = wb.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actualData);

    }
}
