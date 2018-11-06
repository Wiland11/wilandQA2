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

//    Open browser
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
//    Maximize window
        browser.manage().window().maximize();
//    Insert URL
        browser.get("http://rus.delfi.lv");
//    Find articles
        List<WebElement> articles = browser.findElements(ARTICLE);
//    Find second article
        WebElement secondArticle = articles.get(1);
//    Get title from the second article
        WebElement title = secondArticle.findElement(ARTICLE_TITLE);
//    Get text from this title
        String articleTitle = title.getText();
//    Get comments
        String commentCount = secondArticle.findElement(COMMENTS).getText();
//    Remove brackets
        commentCount = commentCount.substring(1, commentCount.length() - 1);
//    Remake comments from String ti Integer
        Integer commentsToCheck = Integer.valueOf(commentCount);
//    Open article
        secondArticle.click();
//    Get text from this title
        String secondPageTitle = browser.findElement(ARTICLE_PAGE_TITLE).getText();
//    Assert title with given
        Assertions.assertEquals(articleTitle, secondPageTitle, "Titles not equal");
//    Get comments
        String articleCommentCount = browser.findElement(ARTICLE_PAGE_COMMENTS).getText();
//    Remove brackets
        articleCommentCount = articleCommentCount.substring(1, articleCommentCount.length() - 1);
//    Remake comments from String to Integer
        Integer articleCommentsToCheck = Integer.valueOf(articleCommentCount);
//    Assert comments with given amount
        Assertions.assertEquals(commentsToCheck, articleCommentsToCheck, "Comments counts not equal");
//    Open comment page
        browser.findElement(ARTICLE_PAGE_COMMENTS).click();
//    Get title of current page
        String commentsPageArticleTitle = browser.findElement(COMMENTS_PAGE_ARTICLE_TITLE).getText();
//    Assert if title from comment page contains given text
        Assertions.assertEquals(articleTitle, commentsPageArticleTitle, "Titles not equal on comments page");
//    Find comments of registered users
        String registeredComments = browser.findElement(REGISTERED_COMMENTS).getText();
//    Remove brackets
        registeredComments = registeredComments.substring(1, registeredComments.length() - 1);
//    Remake comments from String ti Integer
        Integer registredCommentsToCheck = Integer.valueOf(registeredComments);
//    Find comments of anonymous users
        String anonymousComments = browser.findElement(ANONYMOUS_COMMENTS).getText();
//    Remove brackets
        anonymousComments = anonymousComments.substring(1, anonymousComments.length() -1);
//    Remake comments from String ti Integer
        Integer anonymousCommentsToCheck = Integer.valueOf(anonymousComments);
//    Get sum of comments
        Integer sumOfComments = anonymousCommentsToCheck + registredCommentsToCheck;
//    Assert given with our sum
        Assertions.assertEquals(commentsToCheck, sumOfComments, "Sum of comments not equal");
    }
}
