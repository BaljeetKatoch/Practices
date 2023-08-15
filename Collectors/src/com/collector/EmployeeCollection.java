package com.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeCollection {

	 public static void main(String[] args) {
	        List<Employee> employees = new ArrayList<>();

	        Employee employee1 = new Employee("Alice", "Smith", new Department("Sales", "Mumbai"), new Designation("Manager"));
	        Employee employee2 = new Employee("Bob", "Johnson", new Department("HR", "Delhi"), new Designation("Associate"));
	        Employee employee3 = new Employee("Carol", "Brown", new Department("Sales", "Mumbai"), new Designation("Manager"));
	        Employee employee4 = new Employee("David", "Williams", new Department("IT", "Bangalore"), new Designation("Senior Developer"));
	        
	        employees.add(employee1);
	        employees.add(employee2);
	        employees.add(employee3);
	        employees.add(employee4);

	        List<Employee> salesManagers = employees.stream().filter(e->e.getDepartment().getDepartmentName().equals("Sales"))
	                .filter(e->e.getDesignation().getDesignation_type().equals("Manager"))
	                .collect(Collectors.toList());

	        List<Employee> mumbaiEmployees = employees.stream().filter(e->e.getDepartment().getLocation().equals("Mumbai"))
	                .collect(Collectors.toList());

	        List<String> combinedNames = employees.stream().map(e->e.getFirstName()+" "+e.getLastName())
	                .collect(Collectors.toList());

	        System.out.println("Employees in Sales Department with Manager Designation: " + salesManagers);
	        System.out.println("Employees located in Mumbai: " + mumbaiEmployees);
	        System.out.println("Combined Names: " + combinedNames);
	    }
	}


