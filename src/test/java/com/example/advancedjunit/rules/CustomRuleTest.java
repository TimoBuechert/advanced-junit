package com.example.advancedjunit.rules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTest {

    @Rule
    public CustomRule customRule = new CustomRule();

    @Test
    public void exampleTestMethod() {
        // Ihr Testcode hier
        System.out.println("Testmethode wird ausgeführt");
    }
}
