package android.mobile.tests.UserTests;

import android.mobile.tests.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static org.openqa.selenium.By.xpath;

public class LoginViaEmailTest extends BaseTest {

    @Test
    public void userLogin(){
        $(xpath("//android.view.ViewGroup[contains(@index,'1')]")).click();
        $(xpath("//android.widget.EditText[contains(@text,'Enter Your Email *')]")).setValue("imartynenko@s-pro.io");
        $(xpath("//android.widget.EditText[contains(@text,'Enter Your Password *')]")).setValue("Qwerty123$");
        $(xpath("//android.view.ViewGroup[contains(@index,'6')]")).click();

        close();





    }


}
