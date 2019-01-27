package finalHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunctions {

    WebDriver driver;

    public BaseFunctions() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.contains("https://") && !url.contains("http://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void selectFromDropdown(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public void click(By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "There is no such elements!");
        driver.findElement(locator).click();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement (By locator) {
        return driver.findElement(locator);
    }

    public void writeInTextBox(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
