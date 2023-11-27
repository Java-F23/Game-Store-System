package edu.aucegypt.GamesStrore.Helpers;

import java.util.regex.Pattern;

public class Validations 
{

    public static boolean isValidString(String input) {
        // Regular expression to check for a valid string
        String regex = "^[a-zA-Z0-9!@#$%^&*()-=_+{};':\",.<>?/\\\\|`~\\s]+$";
        return Pattern.matches(regex, input);
    }

    // Method to check if the string is a valid Integer
    public static boolean isValidInteger(String input) {
        // Regular expression to check for a valid Integer
        String regex = "^[-+]?\\d+$";
        return Pattern.matches(regex, input);
    }

    // Method to check if the string is a valid floating point number
    public static boolean isValidFloat(String input) {
        // Regular expression to check for a valid floating point number
        String regex = "^[-+]?\\d*\\.\\d+$";
        return Pattern.matches(regex, input);
    }

}
