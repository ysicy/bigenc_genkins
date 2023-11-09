import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BigencCatalogSearcWithJenkins {
    private static final String URL = "https://bigenc.ru/";
    private  static final String ICON = "//span[contains(@class,'_categories')]";
    private static final String CATALOGUE = "//input[contains(@class,'b-search-input')]";
    private static final String VALUE= "Биология";
    private static final String THEMATICPAGENAME= "//div[contains(@class,'bre-thematic-page')]";


    @Test
    void voidSearchingTest() {
        open(URL);
        $x(ICON).click();
        $x(CATALOGUE).setValue(VALUE).click();
        $x("//a[contains(@href,'t/biology')]").click();
        $x(THEMATICPAGENAME).shouldHave(text(VALUE));
    }
}

