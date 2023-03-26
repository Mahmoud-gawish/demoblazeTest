package pages;

import static locators.CartPageLocators.DELETE_ITEM;
import static locators.CartPageLocators.PLACE_ORDER_BUTTON;
import static utils.ElementActions.clickElement;

public class CartPage {

    private CartPage(){

    }

    public static CartPage getCart(){
        return new CartPage();
    }

    public CartPage deleteItemFromCart(){
        clickElement(DELETE_ITEM.by());
        return this;
    }

    public CartPage clickPlaceOrder(){
        clickElement(PLACE_ORDER_BUTTON.by());
        return this;
    }
}
