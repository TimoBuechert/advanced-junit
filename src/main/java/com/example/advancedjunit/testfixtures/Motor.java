package com.example.advancedjunit.testfixtures;

import lombok.Getter;

public class Motor {

    @Getter
    private final String fuel;

    @Getter
    private boolean running;

    public Motor(String fuel) {
        this.fuel = fuel;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

}
