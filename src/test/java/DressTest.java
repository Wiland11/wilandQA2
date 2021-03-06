import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DressTest {
    private final By MAIN_MENU = By.xpath(".//a[@class='sf-with-ul']");
    private final By COLOR_FILTER = By.xpath(".//ul[@id='ul_layered_id_attribute_group_3']/li");
    private final By CATEGORIES_FILTER = By.xpath(".//ul[@id='ul_layered_category_0']/li");
    private final By LOADING = By.xpath(".//ul[@class='product_list row list']/p");

    @Test
    public void orangeDressTest(){
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING));

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
    }
}
