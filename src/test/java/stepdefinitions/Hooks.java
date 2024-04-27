package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.net.MalformedURLException;
import static utilities.Driver.appiumDriver;
import static utilities.Driver.quitDriver;


public class Hooks {
    public static AppiumDriver getDriver() {
        return appiumDriver;
    }



    @Before()
    public void setUpMobile(Scenario scenario) throws MalformedURLException, InterruptedException {


    }


    @After()
    public void tearDownMobile(Scenario scenario) throws MalformedURLException, InterruptedException {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = getDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        quitDriver();
    }
}