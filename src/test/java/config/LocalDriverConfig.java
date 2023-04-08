package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface LocalDriverConfig extends Config {


   @Config.Key("appiumServer")
    String appiumServer();
    @Config.Key("platformName")
    String platformName();

    @Config.Key("deviceName")
    String deviceName();

    @Config.Key("platformVersion")
    String platformVersion();

    @Config.Key("appURL")
    String appURL();

    @Config.Key("appPath")
    String appPath();

    @Config.Key("appPackage")
    String appPackage();

    @Config.Key("appActivity")
    String appActivity();

}
