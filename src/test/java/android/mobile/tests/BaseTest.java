package android.mobile.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;


public class BaseTest {

    private final By loginButton = By.xpath("//android.view.ViewGroup[contains(@index,'1')]");
    private final By fillYourEmailField = By.xpath("//android.widget.EditText[contains(@text,'Enter Your Email *')]");
    private final By fillEnterYourPassword = By.xpath("//android.widget.EditText[contains(@text,'Enter Your Password *')]");
    private final By loginToAccount = By.xpath("//android.view.ViewGroup[contains(@index,'6')]");

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

    protected void loginViaEmail() {
        $(loginButton).click();
        $(fillYourEmailField).setValue("imartynenko@s-pro.io");
        $(fillEnterYourPassword).setValue("Qwerty123$");
        $(loginToAccount).click();
    }

    protected void loginViaMobile() {
        $(By.xpath("//android.view.ViewGroup[contains(@index,'1')]")).click();
        $(By.xpath("//android.view.ViewGroup[contains(@index,'3')]")).click();
        $(By.xpath("//android.widget.EditText[contains(@text,'Enter Your Mobile Number *')]")).shouldBe(Condition.visible);
        $(By.xpath("//android.view.ViewGroup[contains(@index,'12')]")).shouldHave(Condition.text("Ukraine"));
        $(By.xpath("//android.view.ViewGroup[contains(@index,'7')]")).shouldHave(Condition.text("confirm")).click();
        $(By.xpath("//android.widget.TextView[contains(@text,'+380')]")).shouldBe(Condition.visible);
        $(By.xpath("//android.widget.EditText[contains(@text,'Enter Your Mobile Number *')]")).setValue("666274975");
        $(fillEnterYourPassword).setValue("Qwerty123$");
        $(By.xpath("//android.view.ViewGroup[contains(@index,'7')]")).click();

    }



}
