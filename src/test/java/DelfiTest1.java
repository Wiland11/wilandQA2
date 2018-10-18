import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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

        webArticleText.add(webArticleList.get(0).getText());
        webArticleText.add(webArticleList.get(1).getText());
        webArticleText.add(webArticleList.get(2).getText());
        webArticleText.add(webArticleList.get(3).getText());
        webArticleText.add(webArticleList.get(4).getText());

        System.out.println(webArticleText.get(2));

/*        for (WebElement element: webArticleList) {
            System.out.println(element.getText());
        }*/

/*        String webFirstArticle = webArticleList.get(0).getText();
        String webSecondArticle = webArticleList.get(1).getText();
        String webThirdArticle = webArticleList.get(2).getText();
        String webFourthArticle = webArticleList.get(3).getText();
        String webFifthArticle = webArticleList.get(4).getText();*/

//        System.out.println(webArticleListText);

        browser.get("http://m.rus.delfi.lv/");

        List<WebElement> mobArticleList = browser.findElements(MOB_ARTICLE_LIST);
        List<String> mobArticleText = new ArrayList<String>();

        mobArticleText.add(mobArticleList.get(0).getText());
        mobArticleText.add(mobArticleList.get(1).getText());
        mobArticleText.add(mobArticleList.get(2).getText());
        mobArticleText.add(mobArticleList.get(3).getText());
        mobArticleText.add(mobArticleList.get(4).getText());

        System.out.println(mobArticleText.get(2));


/*        String mobFirstArticle = mobArticleList.get(0).getText();
        String mobSecondArticle = mobArticleList.get(1).getText();
        String mobThirdArticle = mobArticleList.get(2).getText();
        String mobFourthArticle = mobArticleList.get(3).getText();
        String mobFifthArticle = mobArticleList.get(4).getText();

        Assertions.assertEquals(webFirstArticle, mobFirstArticle, "first article not same");
        Assertions.assertEquals(webSecondArticle, mobSecondArticle, "second article not same");
        Assertions.assertEquals(webThirdArticle, mobThirdArticle, "third article not same");
        Assertions.assertEquals(webFourthArticle, mobFourthArticle, "fourth article not same");
        Assertions.assertEquals(webFifthArticle, mobFifthArticle, "fifth article not same");*/

        browser.close();
    }
}
