package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.WebsiteSettings;

import java.time.Duration;
import java.util.List;

import static utils.DriverFactory.*;

public final class ElementActions {
    private static final WebDriver driver = getDriver(WebsiteSettings.browserName);
    private static final WebDriverWait wait = getDriverWait();
    private static final Actions actions = getDriverAction();

    public static void clickElement(By elementLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
    }

    public static void clickElementByJavaScript(By elementPath) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementPath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void sendText(By elementLocator, String text) {
        WebElement element = driver.findElement(elementLocator);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public static void acceptAlert() {

        try {
            //Wait 20 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Accepted the alert successfully.");
        } catch (Throwable e) {
            System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
        }
    }

    public static WebElement findElement(By elementsPath) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementsPath)));
    }

    public static void waitUntilElementPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static List<WebElement> findElements(By elementsPath) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(elementsPath)));
    }

    public static boolean isElementPresent(By elementsPath) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementsPath)));
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public static void implicitWait(int time){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

}
