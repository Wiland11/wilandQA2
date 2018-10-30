import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DressTest {
    private final By MAIN_MENU = By.xpath(".//a[@class='sf-with-ul']");
    private final By WONEN_FILTER_MENU = By.xpath(".//ul[@id='ul_layered_id_attribute_group_3']");

    @Test
    public void orangeDressTest(){
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php");

        List<WebElement> mainMenuList = browser.findElements(MAIN_MENU);
boolean qwert = false;
        for (WebElement element : mainMenuList) {
//            System.out.println(element.getText());
            if (element.getText().equals("WOMEN")) {
                element.click();
                qwert = true;
                break;
            }
        }
        Assertions

        List<WebElement> womenMenuList = browser.findElements(WONEN_FILTER_MENU);
        for (int i = 0; i < womenMenuList.size(); i++) {
            System.out.println(womenMenuList.get(i).getText());
        }


//        browser.close();
    }



}
