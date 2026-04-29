package com.rajya.logistics;

// RestCheckpoint is NOT critical - penalty only if delay > 30 min
public class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String id, String loc, double dis, int exp, int acc) {
        super(id, loc, dis, exp, acc);
    }

    @Override
    public boolean isCritical() {
        return false; // Rest stop is not critical
    }

    @Override
    public String getType() {
        return "Rest";
    }

    @Override
    public double Penality() {
        if (!delayedcheck()) {
            return 0; // No penalty if on time
        }
        int delay = actual_time - expected_time;
        if (delay > 30) {
            return delay * 0.5; // Penalty only if delay exceeds 30 minutes
        }
        return 0;
    }
}
