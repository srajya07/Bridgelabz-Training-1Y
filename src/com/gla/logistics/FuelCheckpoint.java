package com.rajya.logistics;

// FuelCheckpoint is critical - flat penalty of 10 if delayed
public class FuelCheckpoint extends Checkpoint {

    public FuelCheckpoint(String id, String loc, double dis, int exp, int acc) {
        super(id, loc, dis, exp, acc);
    }

    @Override
    public boolean isCritical() {
        return true; // Fuel stop is always critical
    }

    @Override
    public String getType() {
        return "Fuel";
    }

    @Override
    public double Penality() {
        if (!delayedcheck()) {
            return 0; // No penalty if on time
        } else {
            return 10; // Flat penalty of 10 if delayed
        }
    }
}
