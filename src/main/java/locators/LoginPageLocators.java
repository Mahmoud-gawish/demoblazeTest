package locators;

import org.openqa.selenium.By;

public enum LoginPageLocators {

    LOGIN_USERNAME_BOX(By.id("loginusername")),
    LOGIN_PASSWORD_BOX(By.id("loginpassword")),
    LOGIN_CONFIRM_BUTTON(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]"));

    private final By locator;

    LoginPageLocators(By locator) {
        this.locator = locator;
    }

    public By by(){return this.locator;}
}
