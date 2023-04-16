import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class CheckTitleTest extends TestBase{

   @Tag("local")
   @Tag ("android")
    @Test
    void successfulCheckTitleTest() {
        step("Check title of the first page", () -> {
                      $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("The Free Encyclopedia\n" +
                              "…in over 300 languages"));
        });
        step("Check title of the second page", () -> {
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("New ways to explore"));

   });
       step("Check title of the third page", () -> {
           $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
           $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Reading lists with sync"));

       });

       step("Check title of the forth page", () -> {
           $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
           $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Send anonymous data"));

       });



    }

}