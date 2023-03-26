package pages;

import static locators.CreateNewAccountLocators.*;
import static utils.ElementActions.*;

public class CreateNewAccount {

    private CreateNewAccount(){

    }

    public static CreateNewAccount getCreateNewAccount(){
        return new CreateNewAccount();
    }

   public CreateNewAccount filUserName(String userName){
       sendText(USERNAME_BOX.by(),userName);
       return this;
   }

    public CreateNewAccount fillPassword(String userName){
        sendText(PASSWORD_BOX.by(),userName);
        return this;
    }

    public CreateNewAccount clickSignUp(){
        clickElement(SIGNUP_CONFIRM_BUTTON.by());
        return this;
    }

    public CreateNewAccount closeSignUP(){
        implicitWait(20);
        waitUntilElementPresent(CLOSE_BUTTON.by());
        clickElement(CLOSE_BUTTON.by());
        return this;
    }
}
