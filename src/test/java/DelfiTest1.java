import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiTest1 {
    private final By WEB_ARTICLES_LIST = By.xpath(".//a[@class='top2012-title']");
    private final By MOB_ARTICLES_LIST = By.xpath(".//a[@class='md-scrollpos']");

    @Test
    public void delfiFiveTitlesTest() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://rus.delfi.lv/");

        List<WebElement> webArticlesList = browser.findElements(WEB_ARTICLES_LIST);
        List<String> webArticlesTexts = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            webArticlesTexts.add(webArticlesList.get(i).getText());
        }

        browser.get("http://m.rus.delfi.lv/");

        List<WebElement> mobArticlesList = browser.findElements(MOB_ARTICLES_LIST);
        List<String> mobArticlesTexts = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            mobArticlesTexts.add(mobArticlesList.get(i).getText());
        }

        Assertions.assertEquals(webArticlesTexts, mobArticlesTexts, "articles not equals");
        browser.close();
    }
}
