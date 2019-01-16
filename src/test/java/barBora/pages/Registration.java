package barBora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Registration {
    BaseFunc baseFunc;

    private final By E_PASTS = By.name("email");
    private final By CITY_DD = By.name("city");
    private final By REGISTRATION_FORM = By.id("b-user-register");

    public Registration(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillEmail(String text) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(E_PASTS);
        baseFunc.writeInTextBox(field, text);
    }

    public void selectCity(String city) {
        baseFunc.waitForElement(CITY_DD);
        baseFunc.selectFromDropdown(CITY_DD, city);
    }
}
