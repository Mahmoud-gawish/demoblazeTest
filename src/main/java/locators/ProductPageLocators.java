package locators;

import org.openqa.selenium.By;

public enum ProductPageLocators {

    ADD_TO_CART_BUTTON(By.linkText("Add to cart"));
    private final By locator;

    ProductPageLocators(By locator) {
        this.locator = locator;
    }

    public By by(){ return this.locator; }
}
