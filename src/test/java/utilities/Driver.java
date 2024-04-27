package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver() {
    }
    private static UiAutomator2Options options;
    private static XCUITestOptions iosOptions;
    public static AppiumDriver appiumDriver;
    public static AppiumDriver getDriver() {

        if (appiumDriver== null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    options = new UiAutomator2Options()
                            .setAutomationName(ConfigReader.getProperty("automationName"))
                            .setPlatformVersion(ConfigReader.getProperty("platformVersion"))
                            .setDeviceName(ConfigReader.getProperty("deviceName"))
                            .setAppActivity("com.dejamobile.cbp.sps.app.mobile.launch.SplashActivity")
                             .setAppPackage("com.dejamobile.cbp.sps.demo")
                            //.setApp("src/test/resources/Apps/dejaMobile.apk")
                            .setNoReset(false)
                            .setNewCommandTimeout(Duration.ofMinutes(10));
                    try {
                        appiumDriver = new AndroidDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);}
                    break;

                case "IOS":
                    iosOptions = new XCUITestOptions();
                    iosOptions.XCODE_ORG_ID_OPTION.contains("" );
                    iosOptions
                            .setDeviceName("iPhone")
                            .setPlatformVersion("15.8.2")
                            .setUdid("081e0d0b4ebe6ba46dd0acf2e7b7e3534056bc9f")
                          // .setApp("")
                            .setAutomationName("XCUITest")
                            .setNoReset(false)
                            .setPlatformName("ios")
                            .setNewCommandTimeout(Duration.ofMinutes(10));

                    try {
                        appiumDriver = new IOSDriver(
                                new URL("http://127.0.0.1:4723"), iosOptions
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }}
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return appiumDriver;
    }

    public static void setBundleId(String bundleId) {
        if (iosOptions != null) {
            iosOptions.setBundleId(bundleId);
        } else {
            throw new IllegalStateException("iosOptions is null. Make sure to call setBundleId after iosOptions initialization.");
        }

    }
    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }}


}

