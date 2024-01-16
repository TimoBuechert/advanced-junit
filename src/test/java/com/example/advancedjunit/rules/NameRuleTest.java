package com.example.advancedjunit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameRuleTest {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void test1() {
        System.out.println(testName.getMethodName());
        assertEquals("test1", testName.getMethodName());
    }
}
