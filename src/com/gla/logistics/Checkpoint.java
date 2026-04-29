package com.rajya.logistics;

abstract class Checkpoint {

    String id;
    String location;
    double distance;       // distance from previous checkpoint in km
    int expected_time;     // expected arrival time in minutes
    int actual_time;       // actual arrival time in minutes

    // Constructor to initialize all fields
    public Checkpoint(String id, String location, double distance, int expected_time, int actual_time) {
        this.id = id;
        this.location = location;
        this.distance = distance;
        this.expected_time = expected_time;
        this.actual_time = actual_time;
    }

    // Checks if the driver arrived late
    public boolean delayedcheck() {
        return actual_time > expected_time;
    }

    // Each subclass must define whether it is critical or not
    public abstract boolean isCritical();

    // Each subclass must return its type as a string
    public abstract String getType();

    // Each subclass must define its own penalty calculation
    public abstract double Penality();
}
