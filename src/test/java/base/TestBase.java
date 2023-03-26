package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import settings.WebsiteSettings;

import java.time.Duration;

import static utils.DriverFactory.getDriver;

public class TestBase {
    private final WebDriver driver = getDriver(WebsiteSettings.browserName);


    @BeforeSuite
    public void setUp() {

        driver.get(WebsiteSettings.URL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver != null) {
            driver.quit();
        }
    }
}
