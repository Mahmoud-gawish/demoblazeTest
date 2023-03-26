package locators;

import org.openqa.selenium.By;

public enum CartPageLocators {
    DELETE_ITEM(By.linkText("Delete")),
    PLACE_ORDER_BUTTON(By.xpath("//button[text()='Place Order']"));

    private final By locator;

    CartPageLocators(By locator) {
        this.locator = locator;
    }

    public By by(){ return this.locator; }
}
