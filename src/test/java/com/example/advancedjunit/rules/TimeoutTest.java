package com.example.advancedjunit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class TimeoutTest {
    @SuppressWarnings("deprecation")
    @Rule
    public Timeout timeout = new Timeout(20); //timeout nach 20 ms


    @SuppressWarnings({"InfiniteLoopStatement", "StatementWithEmptyBody"})
    @Test
    public void firstTest() {
        while (true) {}
    }
}
