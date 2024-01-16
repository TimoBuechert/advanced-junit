package com.example.advancedjunit.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("Before the test");

                try {
                    // This is the actual test execution
                    base.evaluate();
                } finally {
                    System.out.println("After the test");
                }
            }
        };
    }
}
