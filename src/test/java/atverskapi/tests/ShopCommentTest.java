package atverskapi.tests;

import atverskapi.pages.MainFunc;
import atverskapi.pages.MainPage;
import atverskapi.pages.ShopPage;
import atverskapi.pages.ShopsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopCommentTest {
    MainFunc mainFunc = new MainFunc();
    private final String HOME_PAGE = "http://atverskapi.delfi.lv/ru/style";

    @Test
    public void commentsCheck() {
        mainFunc.goToURL(HOME_PAGE);
        MainPage mainPage = new MainPage(mainFunc);
        ShopsPage shopsPage = mainPage.goToShopsPage();
        Integer shopCommentsCount = shopsPage.getCommentByShopName();
        ShopPage shopPage = shopsPage.goToShopPage();
        Integer commentCount = shopPage.getComments();
        Assertions.assertEquals(shopCommentsCount, commentCount, "Wrong count of shop comments");
    }
}
