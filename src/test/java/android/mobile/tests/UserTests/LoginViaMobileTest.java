package android.mobile.tests.UserTests;

import android.mobile.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class LoginViaMobileTest extends BaseTest {

    private final By clickLogout = By.xpath("//android.view.ViewGroup[contains(@index,'6')]");

    @Test
    public void userLogin(){
        loginViaMobile();
        clickLogoutButton();

    }

    private void clickLogoutButton() {
        $(clickLogout).click();
    }

}
