package atverskapi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MainPage {
    MainFunc mainFunc;

//    private final By SHOPS_PAGE = By.xpath(".//ul[@class= 'nav navbar-nav navbar-right']/li");
    private final By SHOPS_PAGE = By.xpath(".//a[@href=\"http://atverskapi.delfi.lv/ru/style/magazini\"]");

    public MainPage(MainFunc mainFunc) {
        this.mainFunc = mainFunc;
    }

    public ShopsPage goToShopsPage() {
        List<WebElement> mainMenuList = new ArrayList<WebElement>(mainFunc.getElements(SHOPS_PAGE));
        boolean menuAssert = false;
        for (WebElement element: mainMenuList) {
            if (element.getText().equals("Магазины")) {
                element.click();
                menuAssert = true;
                break;
            }
        }
        Assertions.assertTrue(menuAssert, "Menu Element not found");
        return new ShopsPage(mainFunc);
    }
}