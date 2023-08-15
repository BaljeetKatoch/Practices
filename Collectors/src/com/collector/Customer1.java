package com.collector;

public class Customer1 {
    private int customer_id;
    private Product product;
    private float amount_paid;
    private String payment_type;
    private String location;
    
	public Customer1(int customer_id, Product product, float amount_paid, String payment_type, String location) {
		super();
		this.customer_id = customer_id;
		this.product = product;
		this.amount_paid = amount_paid;
		this.payment_type = payment_type;
		this.location = location;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(float amount_paid) {
		this.amount_paid = amount_paid;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Customer1 [customer_id=" + customer_id + ", product=" + product + ", amount_paid=" + amount_paid
				+ ", payment_type=" + payment_type + ", location=" + location + "]";
	}
    
    
}
