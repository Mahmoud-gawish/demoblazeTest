package locators;

import org.openqa.selenium.By;

public enum PlaceOrderLocators {

    NAME_BOX(By.id("name")),
    COUNTRY_BOX(By.id("country")),
    CITY_BOX(By.id("city")),
    CREDIT_CART_BOX(By.id("card")),
    MONTH_BOX(By.id("month")),
    YEAR_BOX(By.id("year")),
    PURCHASE(By.xpath("//button[text()='Purchase']")),
    SUCCESSFUL_PURCHASE_TEXT(By.xpath("//h2[text()='Thank you for your purchase!']")),
    DATA_OF_PURCHASE(By.cssSelector(".lead.text-muted")),
    TOTAL_PRICE(By.xpath("//tr[@class='success']/td[3]")),
    OK_BUTTON(By.xpath("//button[text()='OK']"));

    private final By locator;

    PlaceOrderLocators(By locator) {
        this.locator = locator;
    }

    public By by(){
        return this.locator;
    }
}
