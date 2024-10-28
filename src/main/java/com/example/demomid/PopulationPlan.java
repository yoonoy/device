package com.example.demomid;

// Class representing the Population plan with specific cost calculation
public class PopulationPlan extends ElectricityPlan {

    // Constructor initializing the plan with total kWh consumed
    public PopulationPlan(int totalKWh) {
        super(PlanType.POPULATION, totalKWh);
    }

    // Override to calculate cost specific to Population plan
    @Override
    public double calculateCost() {
        if (totalKWh <= 700) {
            return totalKWh * 1.0; // 1 som per kWh for up to 700 kWh
        } else {
            return (700 * 1.0) + ((totalKWh - 700) * 2.16); // 2.16 som per kWh for usage above 700 kWh
        }
    }
}
