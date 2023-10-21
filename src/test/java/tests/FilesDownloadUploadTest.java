package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FilesDownloadUploadTest {

    @Test
    void downloadTxtFileTest() throws Exception{
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloaded = $("a[data-testid='raw-button']").download();
        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] bytes = is.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(content.contains("This repository is the home of _JUnit 5_."));
        }
    }
    @Test

    void downloadXlxFileTest() throws Exception{
        open("https://excelvba.ru/programmes/Teachers?ysclid=lfcu77j9j9951587711");
        File downloaded =  $x("//*[text()='teachers.xls']").download();
        XLS xls = new XLS(downloaded);
        Assertions.assertEquals("дополнительная информация",
                xls.excel.getSheetAt(2).getRow(2).getCell(11).getStringCellValue());
    }
    @Test
    void uploadFileTest() throws Exception{
        open("https://fineuploader.com/demos.html");
        $x("//input[@type = 'file']").uploadFromClasspath("cat.png");
        $(".qq-file-name").shouldHave(text("cat.png"));
    }

    @Test
    void uploadPdfFileTest() throws Exception{
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloaded =  $x("//a[@href = 'junit-user-guide-5.10.0.pdf']").download();
        PDF pdf = new PDF(downloaded);
        Assertions.assertEquals("JUnit 5 User Guide", pdf.title);
    }

}
