import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

public class AppiumSearchTest extends TestBase{

   @Tag("local")
    @Test
    void appiumToSearchTest() {
        step("Skip onboarding page", () -> {
                      $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Click on search container", () -> {
                $(id("org.wikipedia.alpha:id/search_container")).click();

   });

       step("Type Appium in search field", () -> {
                $(id("org.wikipedia.alpha:id/search_src_text")).click();
           $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");

       });
       step("Check that appium on the first line ", () -> {
               $(xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")).
                       shouldHave(Condition.text("Appium"));

       });

    }

}