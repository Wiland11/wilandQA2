package barBora.pages;

import org.openqa.selenium.By;

public class PopUp {
    BaseFunc baseFunc;

    public final By REGISTRATION_TAB = By.xpath(".//a[@aria-controls = 'b-user-register']");

    public PopUp(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Registration goToRegistrationPage(){
        baseFunc.waitForElement(REGISTRATION_TAB);
        baseFunc.getElement(REGISTRATION_TAB).click();
        return new Registration(baseFunc);
    }
}
