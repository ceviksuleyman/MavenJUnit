package day15_excel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Task01 {

    /*
     1.satirdaki 2.hucreye gidelim ve yazdiralim
     1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
     2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
     Satir sayisini bulalim
     Fiziki olarak kullanilan satir sayisini bulun
     Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */

    @Test
    public void test() throws IOException, IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";


        FileInputStream fis = new FileInputStream(dosyaYolu);


        Workbook workbook = WorkbookFactory.create(fis);


        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());


        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1Hucre2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satir1Hucre2);


        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualData = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println(actualData);
        Assert.assertEquals("Kabil", actualData);


        //Satir sayisini bulalim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Toplam Satir Sayisi -> " + (sonSatir + 1));


        //Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir -> " + kullanilanSatirSayisi);


        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String, String> ulkeBaskent = new TreeMap<>();

        for (int i = 0; i <= sonSatir; i++) {

            String keyUlke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String valueBaskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkeBaskent.put(keyUlke, valueBaskent);

        }

        Set<Map.Entry<String, String>> ulkeBaskentEntry = ulkeBaskent.entrySet();

        int count = 1;
        for (Map.Entry<String, String> w : ulkeBaskentEntry) {

            System.out.println(count + "-> " + w);
            count++;
        }
    }
}
