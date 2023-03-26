package pages;

import org.openqa.selenium.By;

import static locators.HomePageLocators.*;
import static pages.CreateNewAccount.getCreateNewAccount;
import static pages.LoginPage.getLoginPage;
import static utils.ElementActions.*;

public class HomePage {
    public static HomePage getHomePage() {
        return new HomePage();
    }


    public CreateNewAccount createNewAccount() {
        clickElement(SIGNUP_BUTTON.by());
        return getCreateNewAccount();
    }

    public LoginPage userLogin(){
        clickElement(LOGIN_BUTTON.by());
        return getLoginPage();
    }

    public String getWelcomeMessage(){
        waitUntilElementPresent(WELCOME_MASSAGE.by());
        return findElement(WELCOME_MASSAGE.by()).getText();
    }

    public HomePage selectPhones(){
        clickElement(PHONES_CATEGORIES.by());
        return this;
    }

    public HomePage selectLaptops(){
        clickElement(LAPTOPS_CATEGORIES.by());
        return this;
    }

    public HomePage selectMonitors(){
        clickElement(MONITORS__CATEGORIES.by());
        return this;
    }

    public boolean isAllItemPresent(int num){
        By path ;
        boolean flag = false;
        for (int i = 1 ; i < num; i++){
            path = By.xpath("//*[@id='tbodyid']/div["+i+"]");
            flag =  isElementPresent(path);
        }
        return flag;
    }

    public HomePage selectSamsungPhone(){
        clickElement(SAMSUNG_PHONE.by());
        return this;
    }

    public HomePage openCartPage(){
        clickElement(CART_PAGE.by());
        return this;
    }

}
