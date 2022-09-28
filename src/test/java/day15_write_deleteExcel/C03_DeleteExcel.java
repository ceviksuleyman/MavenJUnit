package day15_write_deleteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-WorkbookFactory.create(fileInputStream)
    //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
    //-Row objesi olusturun sheet.getRow(3)
    //-Cell objesi olusturun row.getCell(3)
    //-3. Satır 3. Cell'deki veriyi silelim
    //-Silindiğini test edin

    @Test
    public void writeExcelTest01() throws IOException, IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler02.xlsx";


        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // olusturmus oldugumuz dosyayi sistemde isleme alir.


        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = wb.getSheet("Sayfa1"); // excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz


        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(6); // Sayfa1 deki 3. satiri sactik


        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(2); // satir seciminden sonra hucre secimini yaptik


        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        bir cell'deki veriyi silmek icin row objesine ihtiyac vardir.
        row objesi ile removeCell() method'unu kullanarak cell objesi ile belirttigimiz cell degerini silebiliriz.
         */
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        wb.write(fos);

        fos.close();
        fis.close();
        wb.close();


        //-Silindiğini test edin
        //String expectedData = null;
        //String actualData = wb.getSheet("Sayfa1").getRow(5).getCell(1).toString();
        //Assert.assertEquals(expectedData, actualData);

    }
}
