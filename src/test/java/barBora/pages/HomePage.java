package barBora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private final By All_ELEMENTS = By.xpath(".//div[@itemprop = 'isRelatedTo']");
    private final By NAME = By.xpath(".//span[@itemprop = 'name']");
    private final By BUTTON = By.xpath(".//button[@aria-label = 'Pievienot']");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getItemByName(String name) {
        List<WebElement> products = baseFunc.getElements(All_ELEMENTS);
        for (WebElement we : products) {

            if (we.findElement(NAME).getText().contains(name)) {
                return we;
            }
        }
        return null;
    }

    public PopUp addToCartByName(String name){
        getItemByName(name).findElement(BUTTON).click();
        return new PopUp(baseFunc);
    }
}