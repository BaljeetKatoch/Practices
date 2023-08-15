package com.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerCollector {

	public static void main(String[] args) {
	List<Customer> customers = new ArrayList<>();
    Customer customer1 = new Customer("Alice", "Smith", "alice@gmail.com", new Location("Los Angeles", "California"));
    Customer customer2 = new Customer("Rahul", "Singh", "rahul@yahoo.com", new Location("Lucknow", "UP"));
    customers.add(customer1);
    customers.add(customer2);
    
    List<String> details= customers.stream().map((e)->e.getFirstName()+" "+e.getLastName()+" "+e.getLocation()).collect(Collectors.toList());

    System.out.println("Details: " + details);
}
}
