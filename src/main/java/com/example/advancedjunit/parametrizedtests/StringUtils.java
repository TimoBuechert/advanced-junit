package com.example.advancedjunit.parametrizedtests;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author timo.buechert
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static boolean isPalindrome(final String input) {
        if (input == null) {
            return false;
        }
        if (input.isEmpty()) {
            return true;
        }
        final String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

}
