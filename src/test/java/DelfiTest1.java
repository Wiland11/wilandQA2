import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiTest1 {
    private final By WEB_ARTICLE_LIST = By.xpath(".//a[@class='top2012-title']");
    private final By MOB_ARTICLE_LIST = By.xpath(".//a[@class='md-scrollpos']");

    @Test
    public void delfiFiveTitleTest() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://rus.delfi.lv/");

        List<WebElement> webArticleList = browser.findElements(WEB_ARTICLE_LIST);
        List<String> webArticleText = new ArrayList<String>();

        int i;
        for (i = 0; i < 5; i++) {
            webArticleText.add(webArticleList.get(i).getText());
        }

        browser.get("http://m.rus.delfi.lv/");

        List<WebElement> mobArticleList = browser.findElements(MOB_ARTICLE_LIST);
        List<String> mobArticleText = new ArrayList<String>();
        for (i = 0; i < 5; i++) {
            mobArticleText.add(mobArticleList.get(i).getText());
        }

        Assertions.assertArrayEquals(new List[]{webArticleText}, new List[]{mobArticleText}, "articles not equals");
        browser.close();
    }
}
