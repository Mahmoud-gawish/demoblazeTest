package end_to_end;

import base.TestBase;
import data.UserData;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import static data.UserData.getUserData;
import static org.testng.Assert.assertEquals;
import static pages.CartPage.getCart;
import static pages.HomePage.getHomePage;
import static pages.ProductPage.getProductPage;
import static utils.ElementActions.acceptAlert;
import static utils.ElementActions.getAlertText;

public class CartTest extends TestBase {

    HomePage homePage = getHomePage();
    ProductPage productPage = getProductPage();

    CartPage cartPage = getCart();
    UserData userData = getUserData();

    @Test
    public void Test_Add_and_remove_Items(){

        homePage
                .userLogin()
                .fillUserName(userData.getUserNAme())
                .fillPassword(userData.getPassword())
                .clickLogin();
        assertEquals(homePage.getWelcomeMessage(),"Welcome " + userData.getUserNAme());

        homePage.selectSamsungPhone();
        productPage.clickAddToCart();
        String alertText = getAlertText();
        assertEquals(alertText, "Product added.");
        acceptAlert();
        homePage.openCartPage();

        cartPage.deleteItemFromCart();
    }
}
