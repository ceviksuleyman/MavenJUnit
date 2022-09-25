package day14_readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYol = "src/resources/ulkeler.xlsx";


        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        FileInputStream fis = new FileInputStream(dosyaYol);

        //-WorkbookFactory.create(fileInputStream)
        Workbook wb = WorkbookFactory.create(fis);


        //-Turkce baskentler sutununu yazdiralim
        int sonSatir = wb.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir+1); // index 0'dan basladigi icin 0 -> 190 => 191
        /*
        getLastRowNum() method'u bize excel sayfasindaki tum satir numarasini verir
         */

        String turkceBaskentler = "";
        for (int i = 0; i <= sonSatir; i++) {

            turkceBaskentler = wb.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }


        List<String> list = new ArrayList<>(); //s
        for (int i = 0; i <= sonSatir; i++) {

            list.add(wb.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(System.out::println);
    }
}
