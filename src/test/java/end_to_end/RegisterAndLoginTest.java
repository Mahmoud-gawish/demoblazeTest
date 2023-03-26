package end_to_end;

import base.TestBase;
import data.UserData;
import org.testng.annotations.*;
import pages.HomePage;

import static data.UserData.getUserData;
import static org.testng.Assert.assertEquals;
import static pages.HomePage.getHomePage;
import static utils.ElementActions.acceptAlert;
import static utils.ElementActions.getAlertText;
import static utils.Helper.generateRandomPassword;
import static utils.Helper.generateRandomUser;

public class RegisterAndLoginTest extends TestBase {

    HomePage homePage = getHomePage();
    UserData userData = getUserData();

    @Test
    public void test_signUp_userAlreadyExist() {
        homePage
                .createNewAccount()
                .filUserName(userData.getUserNAme())
                .fillPassword(userData.getPassword())
                .clickSignUp();
        String alertText = getAlertText();
        assertEquals(alertText, userData.getUserAlreadyExistMessage());
        acceptAlert();
    }

    @Test
    public void test_signUp_Successfully() {
        homePage
                .createNewAccount()
                .filUserName(generateRandomUser(5))
                .fillPassword(generateRandomPassword(6))
                .clickSignUp();
        String alertText = getAlertText();
        assertEquals(alertText, userData.getSuccessfulSignUPText());
        acceptAlert();
    }

    @Test
    public void test_login_with_wrongPassword()  {

        homePage
                .userLogin()
                .fillUserName(userData.getUserNAme())
                .fillPassword(userData.getWrongPassword())
                .clickLogin();
        String alertText = getAlertText();
        assertEquals(alertText, userData.getWrongPasswordMessage());
        acceptAlert();

    }

    @Test
    public void test_login_with_wrongUser()  {

        homePage
                .userLogin()
                .fillUserName(userData.getWrongUser())
                .fillPassword(userData.getPassword())
                .clickLogin();
        String alertText = getAlertText();
        assertEquals(alertText, userData.getWrongUserMessage());
        acceptAlert();

    }

    @Test
    public void test_successful_login()  {

        homePage
                .userLogin()
                .fillUserName(userData.getUserNAme())
                .fillPassword(userData.getPassword())
                .clickLogin();
        assertEquals(homePage.getWelcomeMessage(),"Welcome " + userData.getUserNAme());

    }

}
