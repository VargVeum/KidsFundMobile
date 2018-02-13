package android.mobile.tests.UserTests;

import android.mobile.tests.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GetHelpTest extends BaseTest {
    private final By needHelpButton = By.xpath("//android.widget.TextView[contains(@text,'Need Help?')]");
    private final By emailField = By.xpath("//android.widget.EditText[contains(@text,'Your Email')]");
    private final By subjectField = By.xpath("//android.widget.EditText[contains(@text,'Subject')]");
    private final By messageField = By.xpath("//android.widget.EditText[contains(@text,'Write Your Message')]");
    private final By submitButton = By.xpath("//android.widget.TextView[contains(@index,'1')]");
    private final By successMessage = byText("Your request has been sent. We will get back to you shortly.");
    private final By okButton = By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1')]");

    AppiumDriver driver;

    @BeforeTest
    public void setUp () throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ENU5T16126001466");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        /*File file = new File("./app", "kidfunds_1.99-dev.apk");
        capabilities.setCapability("app", file.getAbsolutePath());*/

        capabilities.setCapability("appPackage", "com.kidsfunds");
        capabilities.setCapability("appActivity", "com.kidsfunds.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);

    }

    @Test
    public void userLogin() {
        clickNeedHelpButton();
        fillHelpMessageField();
        //$(By.xpath("//android.view.ViewGroup[contains(@index,'0')]")).click();
        clickSubmitButton();
        verifyTextSuccessMessage();
        clickOkButton();

    }

    private void clickOkButton() {
        $(okButton).click();
    }

    private void verifyTextSuccessMessage() {
        $(successMessage).shouldBe(Condition.visible);
    }

    private void clickSubmitButton() {
        $(submitButton).click();
    }

    private void fillHelpMessageField() {
        $(emailField).setValue("imartynenko+1@s-pro.io");
        $(subjectField).setValue("Auto test Nexus");
        $(messageField).setValue("Auto test via Appium");
    }

    private void clickNeedHelpButton() {
        $(needHelpButton).click();
    }
}

