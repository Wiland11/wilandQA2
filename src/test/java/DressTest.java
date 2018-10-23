import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DressTest {
    private final By MAIN_MENU = By.xpath(".//a[@class='sf-with-ul']");

    @Test
    public void orangeDressTest(){
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php");

        List<WebElement> mainMenuList = browser.findElements(MAIN_MENU);

        for (WebElement element : mainMenuList) {
            System.out.println(element.getText());
            if (element.getText().equals("WOMAN")) {
                element.click();
            }

        }
//        browser.close();
    }



//        for (int i = 0; i < mainMenuList.size(); i++) {
//            System.out.println(mainMenuList.get(i).getText());
//        }



}
