package android.mobile.tests.UserTests;

import android.mobile.tests.BaseTest;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GetHelpTest extends BaseTest {
    private final By needHelpButton = By.xpath("//android.widget.TextView[contains(@text,'Need Help?')]");
    private final By emailField = By.xpath("//android.widget.EditText[contains(@text,'Your Email')]");
    private final By subjectField = By.xpath("//android.widget.EditText[contains(@text,'Subject')]");
    private final By messageField = By.xpath("//android.widget.EditText[contains(@text,'Write Your Message')]");
    private final By submitButton = By.xpath("//android.view.ViewGroup[contains(@index,'3')]");
    private final By successMessage = byText("Your request has been sent. We will get back to you shortly.");
    private final By okButton = By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1')]");

    @Test
    public void userLogin(){
        clickNeedHelpButton();
        fillHelpMessageField();
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
        $(emailField).setValue("imartynenko+33@s-pro.io");
        $(subjectField).setValue("Auto test");
        $(messageField).setValue("Auto test via Appium");
    }

    private void clickNeedHelpButton() {
        $(needHelpButton).click();
    }
}

