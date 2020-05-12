/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

import java.util.regex.Pattern;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Bhaskor
 */
public class Validations {

    public boolean checkAlphabetWithSpace(String str) {
        String regex = "^[a-zA-Z\\s]*$";
        return str.matches(regex);
    }

    public boolean checkAlphabetOnly(String str) {
        String regex = "^[a-zA-Z]*$";
        return str.matches(regex);
    }

    public boolean checkAlphabetWithNumberSpecialCharacters(String str) {
        String regex = "^[a-zA-Z0-9\\-#\\.\\(\\)\\/\\'\\,\\s]*$";
        return str.matches(regex);
    }

    public boolean checkAlphabetWithSpecialCharacters(String str) {
        String regex = "^[a-zA-Z\\-#\\.\\(\\)\\/\\'\\,\\s]*$";
        return str.matches(regex);
    }

    public boolean checkNumber(String str) {
        String regex = "^[0-9]*$";
        return str.matches(regex);
    }

    public boolean checkAlphaNumericWithSpace(String str) {
        String regex = "^[a-zA-Z0-9\\s]*$";
        return str.matches(regex);
    }

    public boolean checkAlphaNumericOnly(String str) {
        String regex = "^[a-zA-Z0-9]*$";
        return str.matches(regex);
    }

    public boolean checkEmail(String str) {
        return true;
//        return EmailValidator.getInstance().isValid(str);
    }

    public boolean checkMobile(String str) {
        if (str.length() != 10) {
            return false;
        }
        return checkNumber(str);
    }

    public boolean checkNumberWithLength(String str, int length) {
        if (str.length() != length) {
            return false;
        }
        return checkNumber(str);
    }

    public boolean checkBlank(String str) {
        return str.trim().equals("");
    }

    public boolean checkNumberWithinLength(String str, int low, int high) {
        if (str.length() < low || str.length() > high) {
            return false;
        }
        return checkNumber(str);
    }
}
