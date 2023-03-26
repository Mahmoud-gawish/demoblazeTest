package pages;

import static locators.ProductPageLocators.ADD_TO_CART_BUTTON;
import static utils.ElementActions.clickElement;

public class ProductPage {

    private ProductPage(){

    }

    public static ProductPage getProductPage(){return new ProductPage();}

    public ProductPage clickAddToCart(){

        clickElement(ADD_TO_CART_BUTTON.by());
        return this;
    }
}
