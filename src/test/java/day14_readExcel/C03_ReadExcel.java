package day14_readExcel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest01() {

        /*
        Belirtilen satirNo ve sutunNo degerlerini parametre olarak alip o cell'deki datayi konsolda yazdirin
        Sonucun konsolda yazanla ayni oldugunu dogrulayin
         */
        int row = 12;
        int column = 2;

        cell(row, column);

    }

    public void cell(int row, int column) {

        String dosyaYol = "src/resources/ulkeler.xlsx";

        FileInputStream fis;
        try {
            fis = new FileInputStream(dosyaYol);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Workbook wb;
        try {
            wb = WorkbookFactory.create(fis);
        } catch (IOException | EncryptedDocumentException e) {
            throw new RuntimeException(e);
        }

        // index 0'dan basladigindan bizden istenen satira ulasabilmek icin -1 aldik.
        String actualData = wb.getSheet("Sayfa1").getRow(row - 1).getCell(column - 1).toString();
        System.out.println(actualData);

        String expectedData = "Baku";
        Assert.assertEquals(expectedData, actualData);
    }
}
