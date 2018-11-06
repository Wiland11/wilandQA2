import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DressTest {
    private final By MAIN_MENU = By.xpath(".//a[@class='sf-with-ul']");
    private final By COLOR_FILTER = By.xpath(".//ul[@id='ul_layered_id_attribute_group_3']/li");
    private final By CATEGORIES_FILTER = By.xpath(".//ul[@id='ul_layered_category_0']");

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

        List<WebElement> categoriesFilter = browser.findElements(CATEGORIES_FILTER);
        boolean categoriesAssert = false;
        for (WebElement element : categoriesFilter) {
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

        List<WebElement> colorFilter = browser.findElements(COLOR_FILTER);
        boolean colorAssert = false;
        for (WebElement element : colorFilter) {
            if (element.getText().contains("Orange")) {
                element.click();
                colorAssert = true;
                break;
            }
        }
        Assertions.assertTrue(colorAssert, "Color menu Element not found");

//        browser.close();

        //            System.out.println(element.getText());

//        for (int i = 0; i < colorFilter.size(); i++) {
//            System.out.println(i + ": " + colorFilter.get(i).getText());
//        }

    }
}
