package com.mystream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Customer {
    private String customerName;
    private String location;
    private String planType;
    private int planRange;
    private float amount;
    
     
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public int getPlanRange() {
		return planRange;
	}

	public void setPlanRange(int planRange) {
		this.planRange = planRange;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", location=" + location + ", planType=" + planType
				+ ", planRange=" + planRange + ", amount=" + amount + "]";
	}

	public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        
        Customer customer1 = new Customer();
        customer1.setCustomerName("Alice");
        customer1.setLocation("Mumbai");
        customer1.setPlanRange(4);
        customer1.setAmount(600);
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerName("Bob");
        customer2.setLocation("Delhi");
        customer2.setPlanRange(2);
        customer2.setAmount(700);
        customers.add(customer2);

        Stream<Customer> stream=customers.stream();
        //stream.filter((e)->.getPlanRange()>3).forEach(System.out::println);
        //stream.filter((e)->.getAmount()>500).forEach(System.out::println);
        stream.filter((e)->e.getLocation().equals("Mumbai")).map((e)->e.getAmount()*20/100+e.getAmount()+" "+e.getLocation()).forEach(System.out::println);
        //System.out.println(stream.allMatch(e->e.getPlanRange()>300);
        //System.out.println(stream.anyMatch(e->e.getPlanRange()>300);


        
    }
}