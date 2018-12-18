package atverskapi.pages;

import org.openqa.selenium.By;

public class ShopPage {
    MainFunc mainFunc;

    public final By COMMENTS_COUNT = By.xpath(".//span[@class = 'review-count']");

    public ShopPage(MainFunc mainFunc) {
        this.mainFunc = mainFunc;
    }

    public Integer getComments() {
        String commentsCount = new String(mainFunc.getElement(COMMENTS_COUNT).getText());
        commentsCount = commentsCount.substring(1, commentsCount.length() - 1);

        return Integer.valueOf(commentsCount);
    }

}
