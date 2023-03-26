package pages;

import static locators.LoginPageLocators.*;
import static utils.ElementActions.clickElement;
import static utils.ElementActions.sendText;

public class LoginPage {

    private LoginPage(){

    }

    public static LoginPage getLoginPage(){return new LoginPage();}

    public LoginPage fillUserName(String userName){
        sendText(LOGIN_USERNAME_BOX.by(),userName);
        return this;
    }

    public LoginPage fillPassword(String password){
        sendText(LOGIN_PASSWORD_BOX.by(),password);
        return this;
    }

    public LoginPage clickLogin(){
        clickElement(LOGIN_CONFIRM_BUTTON.by());
        return this;
    }
}
