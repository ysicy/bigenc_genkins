import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BigencCatalogSearcWithJenkins {
    private static final String URL = "https://bigenc.ru/";
    private  static final String ICON = "//span[contains(@class,'_categories')]";
    private static final String CATALOGUE = "//input[contains(@class,'b-search-input')]";
    private static final String VALUE1= "Биология";
    private static final String VALUE2= "История";
    private static final String THEMATICPAGENAME= "//div[contains(@class,'bre-thematic-page')]";


    @Test
    void categorySearchingTest() {
        open(URL);
        $x(ICON).click();
        $x(CATALOGUE).setValue(VALUE1).click();
        $x("//a[contains(@href,'t/biology')]").click();
        $x(THEMATICPAGENAME).shouldHave(text(VALUE1));
    }

    @Test
    void categorySearching2Test(){
        open(URL);
        $x(ICON).click();
        $x(CATALOGUE).setValue(VALUE2).click();
        $x("//a[contains(@href,'t/history')]").click();
        $x(THEMATICPAGENAME).shouldHave(text(VALUE2));

    }
}

