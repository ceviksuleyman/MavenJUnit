package day15_write_deleteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException, IOException {
        // -Dosya yolunu bir String degiskene atayalim
        String dosyaYol = "src/resources/ulkeler.xlsx";


        // -FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYol);


        // -Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // -WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);


        // Excel tablosundaki tum tabloyu consola yazdirin
        int sonSatir = wb.getSheet("Sayfa1").getLastRowNum();


        for (int i = 0; i <= sonSatir; i++) {
            System.out.printf("%-22s %-22s %-22s %-22s\n",
                    wb.getSheet("Sayfa1").getRow(i).getCell(0),
                    wb.getSheet("Sayfa1").getRow(i).getCell(1),
                    wb.getSheet("Sayfa1").getRow(i).getCell(2),
                    wb.getSheet("Sayfa1").getRow(i).getCell(3));
        }

        //String tablo = "";
        //for (int i = 0; i <= sonSatir; i++) {
        //    tablo = wb.getSheet("Sayfa1").getRow(i).getCell(0).toString() + ", "
        //            + wb.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
        //            + wb.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
        //            + wb.getSheet("Sayfa1").getRow(i).getCell(3).toString();
        //    System.out.println(tablo);
        //}
    }
}