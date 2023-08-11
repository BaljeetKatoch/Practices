package com.functional;

class Customer {
    String customerName;
    String planType;
    String location;
    float planAmount;

    public Customer(String customerName, String planType, String location, float planAmount) {
        this.customerName = customerName;
        this.planType = planType;
        this.location = location;
        this.planAmount = planAmount;
    }

    public String toString() {
        return "Customer [customerName=" + customerName + ", planType=" + planType +
               ", location=" + location + ", planAmount=" + planAmount + "]";
    }
}