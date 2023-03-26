package pages;

import static locators.HomePageLocators.WELCOME_MASSAGE;
import static locators.PlaceOrderLocators.*;
import static utils.ElementActions.*;
import static utils.ElementActions.findElement;

public class PlaceOrderPage {
    public PlaceOrderPage() {

    }

    public static PlaceOrderPage getPlaceOrder() {
        return new PlaceOrderPage();
    }

    public PlaceOrderPage fillName(String name){
        sendText(NAME_BOX.by(),name);
        return this;
    }

    public PlaceOrderPage fillCountry(String country){
        sendText(COUNTRY_BOX.by(),country);
        return this;
    }

    public PlaceOrderPage fillCity(String city){
        sendText(CITY_BOX.by(),city);
        return this;
    }

    public PlaceOrderPage fillCreditCart(String card){
        sendText(CREDIT_CART_BOX.by(),card);
        return this;
    }

    public PlaceOrderPage fillMonth(String month){
        sendText(MONTH_BOX.by(),month);
        return this;
    }

    public PlaceOrderPage fillYear(String year){
        sendText(YEAR_BOX.by(),year);
        return this;
    }

    public PlaceOrderPage clickPurchase(){
        clickElement(PURCHASE.by());
        return this;
    }


    public String getSuccessfulPurchaseText(){
        waitUntilElementPresent(SUCCESSFUL_PURCHASE_TEXT.by());
        return findElement(SUCCESSFUL_PURCHASE_TEXT.by()).getText();
    }

    public boolean areTheRightDataAppear(String card, String name) {
        return findElement(DATA_OF_PURCHASE.by()).getText().contains(String.valueOf(getTotalPrice()))
                && findElement(DATA_OF_PURCHASE.by()).getText().contains(card)
                && findElement(DATA_OF_PURCHASE.by()).getText().contains(name);
    }

    public PlaceOrderPage clickOk(){
        clickElement(OK_BUTTON.by());
        return this;
    }

    public String getTotalPrice(){
        waitUntilElementPresent(TOTAL_PRICE.by());
        return findElement(TOTAL_PRICE.by()).getText();
    }

}
