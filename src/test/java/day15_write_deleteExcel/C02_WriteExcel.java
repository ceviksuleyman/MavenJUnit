package day15_write_deleteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

     /*
      1)Yeni bir Class olusturalim WriteExcel
      2) Yeni bir test method olusturalim writeExcelTest()
      3) Adimlari takip ederek 1.satira kadar gidelim
      4) 5.hucreye yeni bir cell olusturalim
      5) Olusturdugumuz hucreye “Nufus” yazdiralim
      6) 2.satir nufus kolonuna 1500000 yazdiralim
      7) 10.satir nufus kolonuna 250000 yazdiralim
      8) 15.satir nufus kolonuna 54000 yazdiralim
      9) Dosyayi kaydedelim
      10)Dosyayi kapatalim
     */

    @Test
    public void test01() throws IOException, IOException {
        String dosyaYolu = "src/resources/ulkeler02.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        // 5.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");


        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");


        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");


        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // excel dosyasina veri girisi yaptiktan sonra dosyayi akisa aldigimiz gibi sonlandirmamiz gerekir.
        // sonrasinda da workbook objemize kayit etmemiz gerekir.

        workbook.write(fos); // write() method'u ile sonlandirdigimiz islemi workbook'a yazdirir.


        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
