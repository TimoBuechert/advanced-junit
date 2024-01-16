package com.example.advancedjunit.testfixtures;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnotherCarTest {

    static private Motor motor;
    private Car carUnderTest;

    @BeforeAll
    static void setUpAll() {
        motor = new Motor("gasoline");
    }

    @BeforeEach
    void setUp() {
        carUnderTest = new Car(motor);
    }

    @Test
    void start() {
        carUnderTest.insertKey();
        carUnderTest.start();
        assertTrue(carUnderTest.isRunning());
    }

    @Test
    void stop() {
        carUnderTest.insertKey();
        carUnderTest.start();
        carUnderTest.stop();
        assertFalse(carUnderTest.isRunning());
    }

    @AfterEach
    void tearDown() {
        carUnderTest.demolish();
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tearDownAll");
    }
}
