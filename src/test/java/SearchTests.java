import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;


@Tag("mobile")
public class SearchTests extends TestBase {
    @Tag("android")
    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Tag("android")
    @Test
    void searchJavaScript() {
        step("Поиск статьи в Википедии", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JavaScript");
        });
        step("Проверка найденных результатов", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(itemWithText("JavaScript")));
    }

    @Tag("android")
    @Test
    void unsuccessfulLoginIn() {
        step("Клик на кнопку для авторизации", () -> {
                    $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
                    $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();

                });

        step("Ввод несуществующего логина и пароля", () -> {
                $(id("org.wikipedia.alpha:id/login_username_text")).sendKeys("ertrterte");
                $(xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText")).sendKeys("ertrterte");
        $(id("org.wikipedia.alpha:id/login_button")).click();
    });

        $(id("org.wikipedia.alpha:id/snackbar_text")).shouldHave(text("Incorrect username or password entered.\n" +
                "Please try again."));
}


    @Tag("ios")
    @Test
    void SearchCovid() {
        step("Ввод текста", () -> {
            $(id("Text Button")).click();
            $(id("Text Input")).sendKeys("Covid");
            $(id("Text Input")).pressEnter();
        });
        step("Проверка текста", () -> {
            $(accessibilityId("Text Output")).shouldHave(text("Covid"));
        });
    }
}



