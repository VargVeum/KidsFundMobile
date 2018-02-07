package android.mobile.tests.UserTests;

import android.mobile.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static org.openqa.selenium.By.xpath;

public class LoginViaEmailTest extends BaseTest {

    private final By clickLogout = xpath("//android.view.ViewGroup[contains(@index,'6')]");

    @Test
    public void userLogin(){

        loginViaEmail();
        clickLogoutButton();

        close();

    }

    private void clickLogoutButton() {
        $(clickLogout).click();
    }

}
