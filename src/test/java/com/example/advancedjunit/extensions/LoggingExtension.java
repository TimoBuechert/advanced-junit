package com.example.advancedjunit.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author timo.buechert
 */
public class LoggingExtension implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance,
                                        ExtensionContext context) throws Exception {
        Logger logger = LoggerFactory.getLogger(testInstance.getClass());
        testInstance.getClass()
                .getMethod("setLogger", Logger.class)
                .invoke(testInstance, logger);
    }

}
