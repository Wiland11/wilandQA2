import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DelfiTest1 {
    private final By WEB_ARTICLE_LIST = By.xpath(".//a[@class='top2012-title']");
    private final By MOB_ARTICLE_LIST = By.xpath(".//a[@class='md-scrollpos']");

    @Test
    public void delfiFiveTitleTest () {

        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://rus.delfi.lv/");

        List<WebElement> webArticleList = browser.findElements(WEB_ARTICLE_LIST);

/*        for (WebElement element: webArticleList) {
            System.out.println(element.getText());
        }*/

        WebElement webFirstArticle = webArticleList.get(0);
        WebElement webSecondArticle = webArticleList.get(1);
        WebElement webThirdArticle = webArticleList.get(2);
        WebElement webFourthArticle = webArticleList.get(3);
        WebElement webFifthArticle = webArticleList.get(4);

        String webFirstArticleText = webFirstArticle.getText();
        String webSecondArticleText = webSecondArticle.getText();
        String webThirdArticleText = webThirdArticle.getText();
        String webFourthArticleText = webFourthArticle.getText();
        String webFifthArticleText = webFifthArticle.getText();

//        System.out.println(webFirstArticle);

        browser.get("http://m.rus.delfi.lv/");

        List<WebElement> mobArticleList = browser.findElements(MOB_ARTICLE_LIST);

        WebElement mobFirstArticle = mobArticleList.get(0);
        WebElement mobSecondArticle = mobArticleList.get(1);
        WebElement mobThirdArticle = mobArticleList.get(2);
        WebElement mobFourthArticle = mobArticleList.get(3);
        WebElement mobFifthArticle = mobArticleList.get(4);

        String mobFirstArticleText = mobFirstArticle.getText();
        String mobSecondArticleText = mobSecondArticle.getText();
        String mobThirdArticleText = mobThirdArticle.getText();
        String mobFourthArticleText = mobFourthArticle.getText();
        String mobFifthArticleText = mobFifthArticle.getText();

        Assertions.assertEquals(webFirstArticleText, mobFirstArticleText, "first article not same");
        Assertions.assertEquals(webSecondArticleText, mobSecondArticleText, "second article not same");
        Assertions.assertEquals(webThirdArticleText, mobThirdArticleText, "third article not same");
        Assertions.assertEquals(webFourthArticleText, mobFourthArticleText, "fourth article not same");
        Assertions.assertEquals(webFifthArticleText, mobFifthArticleText, "fifth article not same");

        browser.close();
    }
}
