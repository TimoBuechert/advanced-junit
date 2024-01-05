package com.example.advancedjunit.parametrizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author timo.buechert
 */
public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void testAdd(final int number) {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add(number, 2);

        //then
        assertEquals(number + 2, result);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSubtract")
    void subtract(final int number1, final int number2, final int expected) {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.subtract(number1, number2);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ArgumentsSource(MultiplicationArgumentsProvider.class)
    void multiply(final int number1, final int number2, final int expected) {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.multiply(number1, number2);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource
    void divide(final int number1, final int number2, final int expected) {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.divide(number1, number2);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> divide() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(25, 10, 2),
                Arguments.of(3, -1, -3)
        );
    }

    private static Stream<Arguments> provideNumbersForSubtract() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(10, 25, -15),
                Arguments.of(3, 1, 2)
        );
    }
}