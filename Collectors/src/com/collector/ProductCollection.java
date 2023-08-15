package com.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class ProductCollection {

	public static void main(String[] args) {
        List<Customer1> customers = new ArrayList<>();

        Customer1 customer1 = new Customer1(1, new Product("ProductA", 100, 2, true, "Store1"), 150, "Card", "Mumbai");
        Customer1 customer2 = new Customer1(2, new Product("ProductB", 200, 3, true, "Store2"), 250, "Cash", "Delhi");
        Customer1 customer3 = new Customer1(3, new Product("ProductA", 100, 1, true, "Store1"), 120, "Card", "Mumbai");
        Customer1 customer4 = new Customer1(4, new Product("ProductC", 300, 1, true, "Store3"), 300, "Card", "Bangalore");
        
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        System.out.println("List of customers as per location:");
        customers.stream()
        		.collect(Collectors.groupingBy(Customer1::getLocation))
                .forEach((location, locationCustomers) -> System.out.println(location + ": " + locationCustomers));


        System.out.println("\nList of customers as per product:");
        customers.stream()
                .collect(Collectors.groupingBy(customer -> customer.getProduct().getProductName()))
                .forEach((product, productCustomers) -> System.out.println(product + ": " + productCustomers));

        System.out.println("\nList of customers as per payment_type:");
        customers.stream()
                .collect(Collectors.groupingBy(Customer1::getPayment_type))
                .forEach((paymentType, paymentTypeCustomers) -> System.out.println(paymentType + ": " + paymentTypeCustomers));

        double averageAmountPaid = customers.stream()
                .mapToDouble(Customer1::getAmount_paid)
                .average()
                .orElse(0);
        System.out.println("\nAverage amount_paid by customers: " + averageAmountPaid);

        System.out.println("\nSum of total amount collected in list as per product:");
        customers.stream()
                .collect(Collectors.groupingBy(customer -> customer.getProduct().getProductName(),
                        Collectors.summingDouble(Customer1::getAmount_paid)))
                .forEach((product, totalAmount) -> System.out.println(product + ": " + totalAmount));
    }
}
