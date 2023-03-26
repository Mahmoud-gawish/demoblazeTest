package data;

import org.json.simple.JSONObject;
import settings.WebsiteSettings;

import static utils.Helper.readJsonFile;

public class UserData {

    private final JSONObject jsonData;

    private UserData() {
        final String filePath = WebsiteSettings.userJsonFile;
        jsonData = readJsonFile(filePath);
    }

    public static UserData getUserData(){
        return new UserData();
    }

    public String getUserNAme() {
        return (String) jsonData.get("userName");
    }
    public String getPassword() {return (String) jsonData.get("password");}
    public String getUserAlreadyExistMessage() {return (String) jsonData.get("userAlreadyExist");}

    public String getSuccessfulSignUPText() {return (String) jsonData.get("successfulSignUpText");}
    public String getWrongPassword() {return (String) jsonData.get("wrongPassword");}
    public String getWrongPasswordMessage() {return (String) jsonData.get("wrongPasswordText");}
    public String getWrongUser() {return (String) jsonData.get("wrongUser");}
    public String getWrongUserMessage() {return (String) jsonData.get("wrongUserMessage");}
}
