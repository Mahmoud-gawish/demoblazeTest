package locators;

import org.openqa.selenium.By;

public enum CreateNewAccountLocators {

    USERNAME_BOX(By.id("sign-username")),
    PASSWORD_BOX(By.id("sign-password")),
    SIGNUP_CONFIRM_BUTTON(By.xpath("//*[@id='signInModal']/div/div/div[3]/button[2]")),
    CLOSE_BUTTON(By.xpath("//*[@id='signInModal']/div/div/div[3]/button[1]"));
    private final By locator;
    CreateNewAccountLocators(By locator){ this.locator = locator; }

    public By by(){return this.locator;}

}
