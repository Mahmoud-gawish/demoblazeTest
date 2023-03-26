package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Random;

public class Helper {

    /*
     * @return random String for registration
     * */

    public static String generateRandomUser(int length) {
        String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(LETTERS.charAt(rand.nextInt(LETTERS.length())));
        }
        return sb.toString();
    }

    /*
     * @return random password for registration
     * */
    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static JSONObject readJsonFile(String filePath) {
        JSONObject obj = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
