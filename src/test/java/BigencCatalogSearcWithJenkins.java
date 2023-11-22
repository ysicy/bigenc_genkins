import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;


@Tag("simple")
public class BigencCatalogSearcWithJenkins extends TestBase{


    private static final String VALUE1= "Биология";
    private static final String VALUE2= "История";
    private static final String VALUE3= "test";
    private static final String  TEXT = "Мы ничего не нашли.";

   @Test
   @Feature("Поиск в каталоге")
   @Story("Поиск значения в каталоге")
   @Owner("ysicy")
   @Severity(SeverityLevel.BLOCKER)
   @DisplayName("Проверяем первое значение в каталоге")
    public void searchIssueTest() {
       SelenideLogger.addListener("allure", new AllureSelenide());
       WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickIcon();
        steps.setValueInCatalogue(VALUE1);
        steps.clickThematicPageLink(VALUE1);
        steps.verifyThematicPageName(VALUE1);
    }
    @Test
    @Feature("Поиск в каталоге")
    @Story("Поиск значения в каталоге")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем второе значение в каталоге")
    void categorySearching2Test(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickIcon();
        steps.setValueInCatalogue(VALUE2);
        steps.clickThematicPageLink(VALUE2);
        steps.verifyThematicPageName(VALUE2);
    }

    @Test
    @Feature("Поиск в каталоге")
    @Story("Поиск неверного значения в каталоге")
    @Owner("ysicy")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем некорректное значение в каталоге")
    void negativeSearchingTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickIcon();
        steps.setValueInCatalogue(VALUE3);
        steps.checkTooltipValue(TEXT);
    }

}