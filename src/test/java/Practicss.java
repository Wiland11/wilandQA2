import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practicss {
    private final By ARTICLE = By.xpath(".//h3[@class = 'top2012-title']");
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'top2012-title']");
    private final By COMMENTS = By.xpath(".//a[@class = 'comment-count']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@class = 'text-size-22 text-size-md-30 d-inline']");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[@class = 'text-size-19 text-size-md-28 text-red-ribbon']");
    private final By COMMENTS_PAGE_ARTICLE_TITLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private final By REGISTERED_COMMENTS = By.xpath(".//a[@class = 'comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']/span");
    private final By ANONYMOUS_COMMENTS = By.xpath(".//a[@class = 'comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']/span");

    @Test
    public void practics() {

        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://rus.delfi.lv");
        List<WebElement> articles = browser.findElements(ARTICLE);
        WebElement secondArticle = articles.get(1);
        WebElement title = secondArticle.findElement(ARTICLE_TITLE);
        String articleTitle = title.getText();
        String commentCount = secondArticle.findElement(COMMENTS).getText();
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        Integer commentsToCheck = Integer.valueOf(commentCount);
        secondArticle.click();
        String secondPageTitle = browser.findElement(ARTICLE_PAGE_TITLE).getText();
        Assertions.assertEquals(articleTitle, secondPageTitle, "Titles not equal");
        String articleCommentCount = browser.findElement(ARTICLE_PAGE_COMMENTS).getText();
        articleCommentCount = articleCommentCount.substring(1, articleCommentCount.length() - 1);
        Integer articleCommentsToCheck = Integer.valueOf(articleCommentCount);
        Assertions.assertEquals(commentsToCheck, articleCommentsToCheck, "Comments counts not equal");
        browser.findElement(ARTICLE_PAGE_COMMENTS).click();
        String commentsPageArticleTitle = browser.findElement(COMMENTS_PAGE_ARTICLE_TITLE).getText();
        Assertions.assertEquals(articleTitle, commentsPageArticleTitle, "Titles not equal on comments page");
        String registeredComments = browser.findElement(REGISTERED_COMMENTS).getText();
        registeredComments = registeredComments.substring(1, registeredComments.length() - 1);
        Integer registeredCommentsToCheck = Integer.valueOf(registeredComments);
        String anonymousComments = browser.findElement(ANONYMOUS_COMMENTS).getText();
        anonymousComments = anonymousComments.substring(1, anonymousComments.length() -1);
        Integer anonymousCommentsToCheck = Integer.valueOf(anonymousComments);
        Integer sumOfComments = anonymousCommentsToCheck + registeredCommentsToCheck;
        Assertions.assertEquals(commentsToCheck, sumOfComments, "Sum of comments not equal");
    }
}
