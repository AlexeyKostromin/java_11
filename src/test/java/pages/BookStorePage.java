package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class BookStorePage {
    SelenideElement
            searchBox = $("[id = searchBox]"),
            firstResult = $x("//div[contains(@class, 'ReactTable')]//a");

    public BookStorePage openPage() {
        open("/books");
        return this;
    }

    public BookStorePage searchFor(String book) {
        searchBox.setValue(book);
        return this;
    }

    public String getFirstSearchResult() {
        String result = "";
        try {
            result = firstResult.getText();
        }
        catch (ElementNotFound e) {
        }
        return result;
    }
    public BookStorePage verifyResult(String expectedBookName) {
        var result = getFirstSearchResult().toLowerCase();
        Assertions.assertTrue(result.contains(expectedBookName.toLowerCase()),
                "expectedBookName was: "+ expectedBookName + ", but result was: " + result);
        return this;
    }





}
