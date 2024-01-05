package com.example.advancedjunit.parametrizedtests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author timo.buechert
 */
public class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"Otto", "Anna", "Hannah", "T", ""})
    void testIsPalindromeIsTrue(final String input) {
        //when
        final boolean result = StringUtils.isPalindrome(input);

        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Timo"})
    @NullSource
    void testIsPalindromeIsFalse(final String input) {
        //when
        final boolean result = StringUtils.isPalindrome(input);

        //then
        assertFalse(result);
    }

    @ParameterizedTest
    @EnumSource(value = Palindrome.class, names = {"OTTO", "HANNAH"}, mode = EnumSource.Mode.EXCLUDE)
    void testIsPalindromeIsTrueEnumSource(final Palindrome input) {
        //when
        final boolean result = StringUtils.isPalindrome(input.name());

        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @EnumSource(value = Palindrome.class, names = ".+NA", mode = EnumSource.Mode.MATCH_ANY)
    void testIsPalindromeIsTrueEnumSourceMatcher(final Palindrome input) {
        //when
        final boolean result = StringUtils.isPalindrome(input.name());

        //then
        assertTrue(result);
    }

    @ParameterizedTest(name = "{index} {0} is a palindrome: {1}")
    @CsvSource({"anna,true", "timo,false", "otto,true", "hannah,true", "t,true"})
    @Tag("slow")
    void testIsPalindromeCsvSource(final String input, final boolean expected) {
        //when
        final boolean result = StringUtils.isPalindrome(input);

        //then
        assertEquals(expected, result);
    }


}