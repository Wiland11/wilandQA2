package atverskapi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MainPage {
    MainFunc mainFunc;

    private final By MAIN_MENU_LIST = By.xpath(".//a[@class='nav-link text-pale-sky p-2']");

    public MainPage(MainFunc mainFunc) {
        this.mainFunc = mainFunc;
    }

    public ShopsPage goToShopsPage() {
        List<WebElement> mainMenuList = new ArrayList<WebElement>(mainFunc.getElements(MAIN_MENU_LIST));
        boolean menuAssert = false;
        for (WebElement element : mainMenuList) {
            if (element.getText().equals("МАГАЗИНЫ")) {
                element.click();
                menuAssert = true;
                break;
            }
        }
        Assertions.assertTrue(menuAssert, "Menu Element not found");
        return new ShopsPage(mainFunc);
    }
}