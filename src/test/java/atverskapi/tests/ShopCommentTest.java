package atverskapi.tests;

import atverskapi.pages.MainFunc;
import atverskapi.pages.MainPage;
import atverskapi.pages.ShopsPage;
import org.junit.jupiter.api.Test;

public class ShopCommentTest {
    MainFunc mainFunc = new MainFunc();
    private final String HOME_PAGE = "http://atverskapi.delfi.lv/ru/style";

    @Test
    public void commentsCheck() {
        mainFunc.goToURL(HOME_PAGE);
        MainPage mainPage = new MainPage(mainFunc);
        ShopsPage shopsPage = mainPage.goToShotsPage();

    }
}
