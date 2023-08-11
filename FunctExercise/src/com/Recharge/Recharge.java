package com.Recharge;

import java.util.function.Function;

public class Recharge {
    int customerId;
    float amount;
    String validDate;

    public Recharge(int customerId, float amount, String validDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.validDate = validDate;
    }
}

