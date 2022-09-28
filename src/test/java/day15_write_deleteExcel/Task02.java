package day15_write_deleteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task02 {

    @Test
    public void test() throws IOException, IOException {

        Map<String, String> ulkelerMap = new HashMap<>();

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatir; i++) {

            // key i. satirdaki 0 index'indeki datadir
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // value i. satirdaki 1,2 ve 3. indexteki datalarin birlesimi
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);
        }

        // entry set
        Set<Map.Entry<String, String>> ulkelerMapEntry = ulkelerMap.entrySet();
        int count = 1;
        for (Map.Entry<String, String> w : ulkelerMapEntry) {

            System.out.println(count + " -> " + w);

            count++;
        }

    }
}
