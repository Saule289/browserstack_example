package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;


public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        LocalDriverConfig localDriverConfig =
                ConfigFactory.create(LocalDriverConfig.class);
        try {
            return new URL(localDriverConfig.appiumServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        LocalDriverConfig localDriverConfig = ConfigFactory.create(LocalDriverConfig.class);

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);


        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(localDriverConfig.deviceName())
                .setPlatformVersion(localDriverConfig.platformVersion())
                .setApp(getAppPath())
                .setAppPackage(localDriverConfig.appPackage())
                .setAppActivity(localDriverConfig.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        LocalDriverConfig localDriverConfig = ConfigFactory.create(LocalDriverConfig.class);

        File app = new File(localDriverConfig.appPath());
        if (!app.exists()) {
            try (InputStream in = new URL(localDriverConfig.appURL()).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}



