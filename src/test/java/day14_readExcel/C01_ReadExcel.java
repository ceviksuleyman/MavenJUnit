package day14_readExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";


        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // olusturmus oldugumuz dosyayi sistemde isleme alir.


        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);
        // wb objesi ile fis objesi ile akisa aldigimiz dosyamiza bir ecxel dosyasi create ettik


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = wb.getSheet("Sayfa1"); // excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz


        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa1 deki 3. satiri sactik


        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // satir seciminden sonra hucre secimini yaptik
        System.out.println(cell);


        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData, cell.getStringCellValue());
    }
}
