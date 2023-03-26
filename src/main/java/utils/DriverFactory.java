package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;
    private static Actions actions;
    private static WebDriverWait wait;

    private static Alert alert;

    public static WebDriver getDriver(String browserName) {
        if (driver == null){
            if (browserName.equalsIgnoreCase("chrome")){
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        return driver;
    }

    public static Actions getDriverAction() {
        if (actions == null) {
            actions = new Actions(driver);
        }
        return actions;
    }

    public static WebDriverWait getDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return wait;
    }

//    public static Alert getDriverAlert(){
//        if (alert == null){
//            alert = new Alert() {
//            }
//        }
//    }
}
