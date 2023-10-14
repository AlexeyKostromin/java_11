package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.BookStorePage;
import pages.CvCreatorPage;
import pages.EnelMedPage;

import java.util.List;
import java.util.stream.Stream;

public class HomeWork10_Junit extends TestBase{

    @Tag("DemoQA")
    @ValueSource(strings = {"api", "javaScript", "GIT"})
    @ParameterizedTest(name = "Book with name {0} can be found using search on books page")

    void findBookByNameTest(String bookName) {
        BookStorePage bookStorePage = new BookStorePage();

        bookStorePage
                .openPage()
                .searchFor(bookName)
                .verifyResult(bookName);
    }

    @Tag("CV")
    @CsvFileSource(resources = "/CvTestData.csv")
    @ParameterizedTest()
    @DisplayName("Verifies that cvPicture reference corresponds to selected CV")

    void cvPictureReferenceTest(String cvName, String cvPicture) {
        CvCreatorPage cvCreatorPage = new CvCreatorPage();

        cvCreatorPage
                .openPage()
                .submitCookie()
                .selectCvType(cvName)
                .verifyCvPicture(cvPicture);
    }

    static Stream<Arguments> headerMenuItemsDependingOfLanguageTest() {
        return Stream.of(
                Arguments.of(EnelMedPage.Language.EN, List.of("Centres and facilities", "Medical services", "About ENEL-MED", "Promotions", "Contact")),
                Arguments.of(EnelMedPage.Language.PL, List.of("Przychodnie i placówki", "Nasi lekarze", "Usługi medyczne", "Kontakt"))
        );
    }
    @Tags({@Tag("Language"), @Tag("Regression")})
    @MethodSource
    @ParameterizedTest
    @DisplayName("Verifies that Menu items displays according to selected language")
    void headerMenuItemsDependingOfLanguageTest(EnelMedPage.Language language, List<String> expectedMenuItems) {
        EnelMedPage enelMedPage = new EnelMedPage();

        enelMedPage
                .openPage()
                .selectLanguage(language)
                .verifyMenuItems(expectedMenuItems);
    }

}
