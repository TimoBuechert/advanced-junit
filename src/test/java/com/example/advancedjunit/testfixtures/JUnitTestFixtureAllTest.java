package com.example.advancedjunit.testfixtures;

import org.junit.jupiter.api.*;

public class JUnitTestFixtureAllTest {
    @BeforeAll
    static void setUpAll()
    {
        System.out.println("setUpAll");
    }
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

    @AfterAll
    static void tearDownAll()
    {
        System.out.println("tearDownAll");
    }
}
