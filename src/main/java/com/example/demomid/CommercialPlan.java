package com.example.demomid;

// Class representing the Commercial plan with a flat cost calculation
public class CommercialPlan extends ElectricityPlan {

    // Constructor initializing the plan with total kWh consumed
    public CommercialPlan(int totalKWh) {
        super(PlanType.COMMERCIAL, totalKWh);
    }

    // Override to calculate cost specific to Commercial plan (flat rate of 2.87 som per kWh)
    @Override
    public double calculateCost() {
        return totalKWh * 2.87;
    }
}
