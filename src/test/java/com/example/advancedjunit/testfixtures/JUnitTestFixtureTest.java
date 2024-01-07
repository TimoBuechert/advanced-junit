package com.example.advancedjunit.testfixtures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitTestFixtureTest {

    @BeforeEach
    void setUp()
    {
        System.out.println("setUp");
    }

    @Test
    void someTest()
    {
        System.out.println("someTest");
    }

    @Test
    void someOtherTest()
    {
        System.out.println("someOtherTest");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("tearDown");
        System.out.println("#########################");
    }
}
