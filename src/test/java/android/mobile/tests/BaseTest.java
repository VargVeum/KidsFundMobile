package android.mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp () throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "ENU5T16126001466");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability("platformVersion", "7.1.2");
        capabilities.setCapability("platformName", "Android");

        /*File file = new File("/home/tester/Downloads", "kidfunds_1.99-dev.apk");
        capabilities.setCapability("app", file.getAbsolutePath());*/

        capabilities.setCapability("appPackage", "com.kidsfunds");
        capabilities.setCapability("appActivity", "com.kidsfunds.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }



}
