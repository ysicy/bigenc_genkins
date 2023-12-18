import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static io.qameta.allure.Allure.step;




public class BigencCatalogSearcWithJenkins extends TestBase{


    private  static final String ICON = "//span[contains(@class,'_categories')]";
    private static final String CATALOGUE = "//input[contains(@class,'b-search-input')]";
    private static final String PLASHKA = "//div[contains(@class,'search-suggestions__wrapper')]";
    private static final String THEMATICPAGENAME= "//h1[contains(@class,'custom-overflow-wrap-anywhere')]";
    private static final String VALUE1= "Биология";
    private static final String VALUE2= "История";
    private static final String VALUE3= "test";
    private static final String  TEXT = "Мы ничего не нашли.";


    @Test
    @Tag("main")
    @Tag("smoke")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем первое значение в каталоге")

    public void searchPageFirstTest(){
    step("Открываем главную страницу bigenc", () -> {
        open("https://bigenc.ru/");
    });
    step("В хэдере нажимаем на иконку каталога", () -> {
        $x(ICON).click();
    });
    step("Вписываем в поле поиска значение " , () -> {
        $x(CATALOGUE).setValue(VALUE1);
    });
    step("Переходим на тематическую страницу", () -> {
        $x("//a[contains(@href,'t/biology')]").click();
    });
    step("Проверяем наличие текста на тематической странице" , () -> {
        $x(THEMATICPAGENAME).shouldHave(Condition.text(VALUE1));
    });
}

    @Test
    @Tag("main")
    @Tag("smoke")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем второе значение в каталоге")
    void searchPageSecondTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу bigenc", () -> {
            open("https://bigenc.ru/");
        });
        step("В хэдере нажимаем на иконку каталога", () -> {
            $x(ICON).click();
        });
        step("Вписываем в поле поиска значение " , () -> {
            $x(CATALOGUE).setValue(VALUE2);
        });
        step("Переходим на тематическую страницу", () -> {
            $x("//a[contains(@href,'t/history')]").click();
        });
        step("Проверяем наличие текста на тематической странице" , () -> {
            $x(THEMATICPAGENAME).shouldHave(Condition.text(VALUE2));
        });
    }

    @Test
    @Tag("main")
    @Owner("ysicy")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем некорректное значение в каталоге")
    void negativeSearchingTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу bigenc", () -> {
            open("https://bigenc.ru/");
        });
        step("В хэдере нажимаем на иконку каталога", () -> {
            $x(ICON).click();
        });
        step("Вписываем в поле поиска значение " , () -> {
            $x(CATALOGUE).setValue(VALUE3);
        });
        step("Проверяем наличие текста в появившемся окне", () -> {
            $x(PLASHKA).shouldHave(text(TEXT));
        });
    }

}