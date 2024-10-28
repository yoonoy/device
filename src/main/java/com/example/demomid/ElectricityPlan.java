package com.example.demomid;

// Abstract class representing a generic electricity plan
public abstract class ElectricityPlan {
    protected PlanType planType; // Type of electricity plan (from PlanType enum)
    protected int totalKWh;      // Total kilowatt-hours consumed

    // Constructor to initialize the plan type and total kWh consumed
    public ElectricityPlan(PlanType planType, int totalKWh) {
        this.planType = planType;
        this.totalKWh = totalKWh;
    }

    // Getter and Setter for the planType
    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    // Getter and Setter for totalKWh
    public int getTotalKWh() {
        return totalKWh;
    }

    public void setTotalKWh(int totalKWh) {
        this.totalKWh = totalKWh;
    }

    // Abstract method to calculate the cost, implemented differently in each subclass
    public abstract double calculateCost();
}
