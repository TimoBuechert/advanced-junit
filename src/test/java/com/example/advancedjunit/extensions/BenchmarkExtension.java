package com.example.advancedjunit.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @author timo.buechert
 */
public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = LoggerFactory.getLogger(BenchmarkExtension.class);


    @Override
    public void beforeTestExecution(ExtensionContext context) {
        var stopWatch = new StopWatch();
        context.getStore(ExtensionContext.Namespace.create(BenchmarkExtension.class, context.getRequiredTestMethod()))
                .put("stopWatch", stopWatch);
        stopWatch.start();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        var testMethod = context.getRequiredTestMethod();
        var stopWatch = context.getStore(ExtensionContext.Namespace.create(BenchmarkExtension.class, testMethod))
                .get("stopWatch", StopWatch.class);
        stopWatch.stop();

        logger.info(String.format("Method %s#%s executed in %d ms%n", context.getRequiredTestClass().getName(),
                testMethod.getName(),
                stopWatch.lastTaskInfo().getTimeMillis()));
    }
}
