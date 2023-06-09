import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    public static String device = System.getProperty("env");

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = null;

        if (device.equals("android") || device.equals("ios")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {

        Attach.pageSource();
        String sessionId = Selenide.sessionId().toString();
        closeWebDriver();
        if (device.equals("android") || device.equals("ios")) {
            Attach.addVideo(sessionId);
        }
            }

}
