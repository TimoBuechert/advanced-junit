package com.example.advancedjunit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.is;

public class ErrorCollectorTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test() {
        collector.checkThat(1 + 1, is(3));
        collector.addError(new Exception("something went wrong"));
    }
}
