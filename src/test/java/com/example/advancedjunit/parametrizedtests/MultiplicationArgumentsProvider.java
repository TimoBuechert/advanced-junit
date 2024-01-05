package com.example.advancedjunit.parametrizedtests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @author timo.buechert
 */
public class MultiplicationArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(10, 25, 250),
                Arguments.of(3, -1, -3)
        );
    }

}
