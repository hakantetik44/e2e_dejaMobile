package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppOperationManager {
    WebDriver driver;
    List<String> appNames = new ArrayList<>();

    public AppOperationManager(WebDriver driver) {
        this.driver = driver;
        addAppNames(new String[]{"wisniowski", "hexaom", "flexomv3", "kizconnect"});
    }
    public void addAppNames(String[] newAppNames) {
        appNames.addAll(Arrays.asList(newAppNames));
    }

    public void clickOnElement(String variable) {
        for (String appName : appNames) {
            setImplicitlyWait(1);
            String locator = "com.overkiz." + appName + ":id/" + variable;
            WebElement element = findElementIfExists(locator);
            if (element != null) {
                element.click();
                resetImplicitlyWait();
                return;}}
        resetImplicitlyWait();
    }
    public WebElement findElementIfExists(String locator) {
        try {
            return driver.findElement(By.id(locator));
        } catch (Exception e) {
            return null;}}
    private void setImplicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);}

    private void resetImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);}
}
