package end_to_end;

import base.TestBase;
import data.CartData;
import data.UserData;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductPage;

import static data.CartData.getCartData;
import static data.UserData.getUserData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CartPage.getCart;
import static pages.HomePage.getHomePage;
import static pages.PlaceOrderPage.getPlaceOrder;
import static pages.ProductPage.getProductPage;
import static utils.ElementActions.acceptAlert;
import static utils.ElementActions.getAlertText;

public class CheckoutTest extends TestBase {

    HomePage homePage = getHomePage();
    ProductPage productPage = getProductPage();

    CartPage cartPage = getCart();

    PlaceOrderPage placeOrderPage = getPlaceOrder();
    CartData cartData = getCartData();
    UserData userData = getUserData();

    @Test
    public void test_Successful_checkout() {
        homePage
                .userLogin()
                .fillUserName(userData.getUserNAme())
                .fillPassword(userData.getPassword())
                .clickLogin();
        assertEquals(homePage.getWelcomeMessage(), "Welcome " + userData.getUserNAme());

        homePage.selectSamsungPhone();
        productPage.clickAddToCart();
        String alertText = getAlertText();
        assertEquals(alertText, "Product added.");
        acceptAlert();
        homePage.openCartPage();
        cartPage.clickPlaceOrder();

        String successText = placeOrderPage
                .fillName(cartData.getFullNAme())
                .fillCountry(cartData.getCountry())
                .fillCity(cartData.getCity())
                .fillCreditCart(cartData.getCreditCart())
                .fillMonth(cartData.getMonth())
                .fillYear(cartData.getYear())
                .clickPurchase()
                .getSuccessfulPurchaseText();
        assertEquals(successText, cartData.getSuccessText());
        assertTrue(placeOrderPage.areTheRightDataAppear(cartData.getCreditCart(), cartData.getFullNAme()));

        placeOrderPage.clickOk();
    }
}
