package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.BookStorePage;
import pages.EnelMedPage;

public class HomeWork10_Junit extends TestBase{

    @ValueSource(strings = {"api", "javaScript", "GIT"})
    @ParameterizedTest(name = "Book with name {0} can be found using search on books page")
    @Tag("book")
    void findBookByNameTest(String bookName) {
        BookStorePage bookStorePage = new BookStorePage();

        bookStorePage
                .openPage()
                .searchFor(bookName)
                .verifyResult(bookName);

    }
    @ValueSource(strings = {"api", "javaScript", "GIT"})
    @ParameterizedTest(name = "Book with name {0} can be found using search on books page")
    @Tag("language")
    void displayButtonsTest(String bookName) {
        EnelMedPage enelMedPage = new EnelMedPage();

        enelMedPage
                .openPage().selectLanguage(EnelMedPage.Language.EN);


    }




}
