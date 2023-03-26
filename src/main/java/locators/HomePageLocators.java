package locators;

import org.openqa.selenium.By;

public enum HomePageLocators {

    SIGNUP_BUTTON(By.id("signin2")),
    LOGIN_BUTTON(By.id("login2")),
    WELCOME_MASSAGE(By.xpath("//*[@id='nameofuser']")),
    PHONES_CATEGORIES(By.linkText("Phones")),
    LAPTOPS_CATEGORIES(By.linkText("Laptops")),
    MONITORS__CATEGORIES(By.linkText("Monitors")),
    SAMSUNG_PHONE(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a")),

    CART_PAGE(By.linkText("Cart"));

    private final By locator;

    HomePageLocators(By locator) {
        this.locator = locator;
    }

    public By by() {return this.locator;}
}
