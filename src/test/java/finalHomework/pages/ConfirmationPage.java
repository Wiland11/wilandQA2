package finalHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ConfirmationPage {

    private BaseFunctions baseFunctions;

    private final By FINAL_TEXT = By.xpath(".//div[@class = 'finalTxt']");

    public ConfirmationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void checkConfirmationPage() {
        baseFunctions.waitForElement(FINAL_TEXT);
        Assertions.assertTrue(baseFunctions.getElement(FINAL_TEXT).isDisplayed(), "Incorrect Confirmation Page");
    }

}
