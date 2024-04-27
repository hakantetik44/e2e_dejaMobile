package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static utilities.Driver.getDriver;

public class DejaMobilePage {

    public DejaMobilePage() {

        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

    }

    @AndroidFindBy(id = "com.dejamobile.cbp.sps.demo:id/login_logo")
    public WebElement logo;

    @AndroidFindBy(id = "com.dejamobile.cbp.sps.demo:id/login_usernameField")
    public WebElement placeEmail;

    @AndroidFindBy(id = "com.dejamobile.cbp.sps.demo:id/login_passwordField")
    public WebElement placeMotDePasse;

    @AndroidFindBy(id="com.dejamobile.cbp.sps.demo:id/login_loginButton")
    public WebElement btnSeConnecter;

    @AndroidFindBy(id="com.dejamobile.cbp.sps.demo:id/login_error")
    public WebElement textError;

    @AndroidFindBy(id="com.dejamobile.cbp.sps.demo:id/textinput_error")
    public WebElement textErrorLesChampsVides;







}

