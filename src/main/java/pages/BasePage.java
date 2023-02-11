package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }


    protected WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public void submitByLocator(By locator) {
        WebElement element = find(locator);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public void submitByWebElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);

    }


    public WebElement waitUntilVisible(By locator, int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}
