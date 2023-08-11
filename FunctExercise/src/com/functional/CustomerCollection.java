package com.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CustomerCollection {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Rahul", "Premium", "City A", 300));
        customers.add(new Customer("James", "Basic", "City B", 150));
        customers.add(new Customer("Sunil", "Standard", "City C", 220));
        customers.add(new Customer("David", "Premium", "City D", 180));

        Collections.sort(customers, (c1, c2) -> Float.compare(c1.planAmount, c2.planAmount));

        System.out.println("Sorted Customers:");
        customers.forEach(System.out::println);

        Predicate<Customer> planAmountFilter = customer -> customer.planAmount >= 200;
        customers.removeIf(planAmountFilter.negate());

        System.out.println("Customers with planAmount >= 200:");
        customers.forEach(System.out::println);
    }
}
