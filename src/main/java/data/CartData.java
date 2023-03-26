package data;

import org.json.simple.JSONObject;
import settings.WebsiteSettings;

import static utils.Helper.readJsonFile;

public class CartData {

    private final JSONObject jsonData;

    private CartData() {
        final String filePath = WebsiteSettings.cartJsonFile;
        jsonData = readJsonFile(filePath);
    }

    public static CartData getCartData(){
        return new CartData();
    }

    public String getFullNAme() {
        return (String) jsonData.get("fullName");
    }
    public String getCountry() {
        return (String) jsonData.get("country");
    }
    public String getCity() {
        return (String) jsonData.get("city");
    }
    public String getCreditCart() {
        return (String) jsonData.get("creditCart");
    }
    public String getMonth() {
        return (String) jsonData.get("month");
    }
    public String getYear() {
        return (String) jsonData.get("year");
    }
    public String getSuccessText() {
        return (String) jsonData.get("successText");
    }


}
