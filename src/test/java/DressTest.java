import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DressTest {
    private final By MAIN_MENU = By.xpath(".//a[@class='sf-with-ul']");
    private final By COLOR_FILTER_MENU = By.xpath(".//ul[@id='ul_layered_id_attribute_group_3']");
    private final By CATEGORIES_FILTER_MENU = By.xpath(".//ul[@id='ul_layered_category_0']");

    @Test
    public void orangeDressTest(){
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php");

        List<WebElement> mainMenuList = browser.findElements(MAIN_MENU);
        boolean menuAssert = false;
        for (WebElement element : mainMenuList) {
            if (element.getText().equals("WOMEN")) {
                element.click();
                menuAssert = true;
                break;
            }
        }
        Assertions.assertTrue(menuAssert, "Menu Element not found");

        List<WebElement> categoriesMenuList = browser.findElements(CATEGORIES_FILTER_MENU);
        boolean categoriesAssert = false;
        for (WebElement element : categoriesMenuList) {
            if (element.getText().contains("Dresses")) {
                element.click();
                categoriesAssert = true;
                break;
            }
        }
        Assertions.assertTrue(categoriesAssert, "Categories menu Element not found");

        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        List<WebElement> womenMenuList = browser.findElements(COLOR_FILTER_MENU);
        boolean colorAssert = false;
        for (WebElement element : womenMenuList) {
            if (element.getText().contains("Orange")) {
                element.click();
                element.click();
                element.click();
                colorAssert = true;
                break;
            }
        }
        Assertions.assertTrue(colorAssert, "Color menu Element not found");

//        browser.close();

        //            System.out.println(element.getText());


//        for (int i = 0; i < womenMenuList.size(); i++) {
//            System.out.println(womenMenuList.get(i).getText());
//        }
    }



}
