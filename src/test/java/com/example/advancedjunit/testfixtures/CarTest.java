package com.example.advancedjunit.testfixtures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car carUnderTest;

    @BeforeEach
    void setUp() {
        Motor motor = new Motor("gasoline");
        carUnderTest = new Car(motor);
    }

    @Test
    void start() {
        carUnderTest.start();
        assertTrue(carUnderTest.isRunning());
    }

    @Test
    void stop() {
        carUnderTest.start();
        carUnderTest.stop();
        assertFalse(carUnderTest.isRunning());
    }

    @Test
    void insertKey() {
        carUnderTest.insertKey();
        assertTrue(carUnderTest.isKeyPresent());
    }

    @Test
    void removeKey() {
        carUnderTest.insertKey();
        carUnderTest.removeKey();
        assertFalse(carUnderTest.isKeyPresent());
    }

    @Test
    void isRunning() {
        carUnderTest.insertKey();
        carUnderTest.start();
        assertTrue(carUnderTest.isRunning());
    }

    @AfterEach
    void tearDown() {
        carUnderTest.demolish();
    }
}