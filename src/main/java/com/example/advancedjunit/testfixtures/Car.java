package com.example.advancedjunit.testfixtures;

import lombok.Getter;

public class Car {
    private final Motor motor;
    @Getter
    private boolean keyPresent;

    public Car(Motor motor) {
        this.motor = motor;
    }

    public void start() {
        if (keyPresent) {
            motor.start();
        }
    }

    public void stop() {
        motor.stop();
    }

    public void insertKey() {
        keyPresent = true;
    }

    public void removeKey() {
        stop();
        keyPresent = false;
    }

    public boolean isRunning() {
        return motor.isRunning();
    }

    public void demolish() {
        motor.stop();
        System.out.println("Demolishing car");
    }
}
