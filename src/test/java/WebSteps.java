

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.Step;


public class WebSteps {

        private  static final String ICON = "//span[contains(@class,'_categories')]";
        private static final String CATALOGUE = "//input[contains(@class,'b-search-input')]";
        private static final String PLASHKA = "//div[contains(@class,'search-suggestions__wrapper')]";

        private static final String THEMATICPAGENAME= "//div[contains(@class,'bre-thematic-page')]";

        @Step("Open main page")
        public void openMainPage(){
            open("https://bigenc.ru/");
        }
        @Step("Click on the icon")
        public void clickIcon() {
            $x(ICON).click();
        }
        @Step("Set value in the catalogue")
        public void setValueInCatalogue(String value) {
            $x(CATALOGUE).setValue(value).click();
        }
        @Step("Check text in tooltip")
        public void checkTooltipValue(String value){ $x(PLASHKA).shouldHave(text(value)); }
        @Step("Click on the thematic page link")
        public void clickThematicPageLink(String link) {
            $x("//a[contains(@href,'t/biology')]").click();
        }
        @Step("Verify thematic page name")
        public void verifyThematicPageName(String value) {
            $x(THEMATICPAGENAME).shouldHave(text(value));
        }




    }



