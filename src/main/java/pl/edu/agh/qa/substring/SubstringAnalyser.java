package pl.edu.agh.qa.substring;


import pl.edu.agh.qa.substring.item.Substring;

import java.util.ArrayList;
import java.util.List;

public class SubstringAnalyser {
    private int substringSize;

    public SubstringAnalyser(int substringSize) {
        this.substringSize = substringSize;
    }

    public List<Substring> extractSubstrings(String from) {
        List<Substring> result = new ArrayList<>();
        String previousChar = "";
        int length = 1;
        int position = 0;
        for (int i = 0; i < from.length(); i++) {
            if (String.valueOf(from.charAt(i)).equals(previousChar)) {
                length++;
            } else if (length >= substringSize) {
                result.add(new Substring(previousChar, position, length));
                previousChar = String.valueOf(from.charAt(i));
                length = 1;
                position = i;
            } else {
                previousChar = String.valueOf(from.charAt(i));
                length = 1;
                position = i;
            }
        }
        if (length >= substringSize) {
            result.add(new Substring(previousChar, position, length));
        }
        return result;
    }

    /**
     * Password requirements:
     * min 12 characters,
     * min 1 capital letter
     * min 1 letter
     * min 1 digit
     * min one sign from the list !*&[]%$
     *
     * @param password
     * @return
     */
    public boolean isCorrectPassword(String password) {
        if (password.length() < 12) {
            return false;
        }
        boolean capital = false;
        boolean letter = false;
        boolean digit = false;
        boolean sign = false;
        for (int i = 0; i < password.length(); i++) {
            if (String.valueOf(password.charAt(i)).matches("[a-z]{1}")) {
                letter = true;
            }
            if (String.valueOf(password.charAt(i)).matches("[A-Z]{1}")) {
                capital = true;
            }
            if (String.valueOf(password.charAt(i)).matches("[[!*&%$]]{1}")) {
                sign = true;
            }
            if (String.valueOf(password.charAt(i)).matches("[0-9]{1}")) {
                digit = true;
            }
        }
        return capital && letter && digit && sign;
    }
}
