package com.example.demomid;

// Class representing the Highlands plan with a flat cost calculation
public class HighlandsPlan extends ElectricityPlan {

    // Constructor initializing the plan with total kWh consumed
    public HighlandsPlan(int totalKWh) {
        super(PlanType.HIGHLANDS, totalKWh);
    }

    // Override to calculate cost specific to Highlands plan (flat rate of 1 som per kWh)
    @Override
    public double calculateCost() {
        return totalKWh * 1.0;
    }
}
