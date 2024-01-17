package com.example.advancedjunit.listener;

import com.example.advancedjunit.extensions.TestInterceptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author timo.buechert
 */
public class ExecutionListener implements TestExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        logger.info("Test " + testIdentifier.getDisplayName() + " finished with status " + testExecutionResult.getStatus());
    }

}
