package atverskapi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShopsPage {
    MainFunc mainFunc;

    private final By SHOPS_LIST = By.xpath(".//div[@class = 'col-xs-6 col-sm-3']");
    private final By SHOPS_COMMENTS = By.xpath(".//div[@class = 'card-info-user-rating-stars']");
    private final String SHOP_NAME = "KIDS & MOMS";

    public ShopsPage(MainFunc mainFunc) {
        this.mainFunc = mainFunc;
    }

    public Integer getCommentByShopName() {
        String commentCount = null;
        List<WebElement> shopsList = new ArrayList<WebElement>(mainFunc.getElements(SHOPS_LIST));
        boolean shopsAssert = false;
        for (int i = 0; i < shopsList.size(); i++) {
            if (shopsList.get(i).getText().contains(SHOP_NAME)) {
                commentCount = shopsList.get(i).findElement(SHOPS_COMMENTS).getText();
                commentCount = commentCount.substring(1, commentCount.length() - 1);
                shopsAssert = true;
                break;
            }
        }
        Assertions.assertTrue(shopsAssert, "Shop not found");
        return Integer.valueOf(commentCount);
    }

    public ShopPage goToShopPage() {
        List<WebElement> shopsList = new ArrayList<WebElement>(mainFunc.getElements(SHOPS_LIST));
        boolean shopAssert = false;
        for (WebElement element : shopsList) {
            if (element.getText().contains(SHOP_NAME)) {
                element.click();
                shopAssert = true;
                break;
            }
        }
        Assertions.assertTrue(shopAssert, "Shop not fount");
        return new ShopPage(mainFunc);
    }
}
