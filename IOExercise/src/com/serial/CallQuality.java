package com.serial;

import java.io.Serializable;

public class CallQuality implements Serializable{
	private int callId;
	private int callDuration;
	private String callQualityGrade;
	private String customerName;

	public CallQuality()
	{
		
	}
	
	
	
	public CallQuality(int callId,int callDuration, String callQualityGrade, String customerName) {
		super();
		this.callId = callId;
		this.callDuration = callDuration;
		this.callQualityGrade = callQualityGrade;
		this.customerName = customerName;
	}



	public int getcallId() {
		return callId;
	}
	public void setcallId(int callId) {
		this.callId = callId;
	}
	public int getcallDuration() {
		return callDuration;
	}
	public void setcallDuration(int callDuration) {
		this.callDuration = callDuration;
	}
	public String getcallQualityGrade() {
		return callQualityGrade;
	}
	public void setcallQualityGrade(String callQualityGrade) {
		this.callQualityGrade = callQualityGrade;
	}
	public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}
	

}

