package atverskapi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class MainFunc {
    WebDriver driver;

    public MainFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty(), "Elements ton found");
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "There is no elements!");
        return driver.findElement(locator);
    }

}

