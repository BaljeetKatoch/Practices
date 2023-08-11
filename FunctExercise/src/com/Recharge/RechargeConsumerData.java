package com.Recharge;

import java.util.function.Function;

public class RechargeConsumerData {
	public void rechargeData(Function<Recharge, String> function) {
        Recharge[] recharges = {
                new Recharge(1, 50.0f, "2023-08-15"),
                new Recharge(2, 100.0f, "2023-08-18"),
                new Recharge(3, 200.0f, "2023-08-20")
        };

        for (Recharge recharge : recharges) {
            String result = function.apply(recharge);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        RechargeConsumerData rechargeConsumerData = new RechargeConsumerData();

        rechargeConsumerData.rechargeData(recharge -> "Customer ID: " + recharge.customerId +
                ", Amount Recharged: " + recharge.amount);
    }
}
