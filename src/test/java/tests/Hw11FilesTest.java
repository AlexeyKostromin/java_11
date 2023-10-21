package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Hw11FilesTest {
    ClassLoader cl =  Hw11FilesTest.class.getClassLoader();
    @Test
    void zipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("hw11_files.ZIP");
             ZipInputStream zis = new ZipInputStream(stream)) {

            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null){
                String name = entry.getName();
                if(name.toLowerCase().contains(".pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertTrue(pdf.text.contains("IPO GOCO"));

                } else if (name.toLowerCase().contains(".csv")) {
                    Reader reader = new InputStreamReader(zis);
                    CSVReader csvReader = new CSVReader(reader);
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[] {"Mateush", "Java"}, content.get(1));
                    Assertions.assertArrayEquals(new String[] {"Marek", "Java advanced"}, content.get(2));

                } else if (name.toLowerCase().contains(".xlsx")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals("Наименование эмитента",
                            xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
                }
            }

        }
    }



}