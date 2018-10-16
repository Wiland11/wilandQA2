import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiTest {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']");

    @Test
    public void delfiFirstTitleTest () {
        // у нас есть название статьи
        String articleToCheck = "На большей части территории Латвии побит рекорд тепла для 16 октября";
        // открыть хром
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        // расширить броузер
        browser.manage().window().maximize();
        // зайти на сайт делфи - http://www.delfi.ru/
        browser.get("http://rus.delfi.lv/");
        // найти первую статью
        WebElement arcicle = browser.findElement(ARTICLE_TITLE);
        // взять название
        String articleText = arcicle.getText();
        // сравнить названия с данной нам
        Assertions.assertEquals(articleToCheck, articleText, "wrong article title");
        // закрыть броузер
        browser.close();

    }
}
