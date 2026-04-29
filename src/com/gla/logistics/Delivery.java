package com.rajya.logistics;

// Delivery is a critical checkpoint - penalty = (actual - expected) * 2
public class Delivery extends Checkpoint {

    public Delivery(String id, String loc, double dis, int exp, int acc) {
        super(id, loc, dis, exp, acc);
    }

    @Override
    public boolean isCritical() {
        return true; // Delivery is always critical
    }

    @Override
    public String getType() {
        return "Delivery";
    }

    @Override
    public double Penality() {
        if (!delayedcheck()) {
            return 0; // No penalty if on time
        } else {
            return (actual_time - expected_time) * 2;
        }
    }
}
