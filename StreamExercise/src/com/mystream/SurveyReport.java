package com.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SurveyReport {
    private int surveyId;
    private String employeeName;
    private String location;
    private int total_connection_request;
    private int no_of_days_for_request_completion;
    private int average_request_per_day;

    
    
    public int getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getTotal_connection_request() {
		return total_connection_request;
	}



	public void setTotal_connection_request(int total_connection_request) {
		this.total_connection_request = total_connection_request;
	}



	public int getNo_of_days_for_request_completion() {
		return no_of_days_for_request_completion;
	}



	public void setNo_of_days_for_request_completion(int no_of_days_for_request_completion) {
		this.no_of_days_for_request_completion = no_of_days_for_request_completion;
	}



	public int getAverage_request_per_day() {
		return average_request_per_day;
	}



	public void setAverage_request_per_day(int average_request_per_day) {
		this.average_request_per_day = average_request_per_day;
	}



	@Override
	public String toString() {
		return "SurveyReport [surveyId=" + surveyId + ", employeeName=" + employeeName + ", location=" + location
				+ ", total_connection_request=" + total_connection_request + ", no_of_days_for_request_completion="
				+ no_of_days_for_request_completion + ", average_request_per_day=" + average_request_per_day + "]";
	}



	public static void main(String[] args) {
        List<SurveyReport> reports = new ArrayList<>();
        
        SurveyReport report1 = new SurveyReport();
        report1.setSurveyId(1);
        report1.setEmployeeName("Alice");
        report1.setLocation("Delhi");
        report1.setTotal_connection_request(100);
        report1.setNo_of_days_for_request_completion(10);
        report1.setAverage_request_per_day(10);
        reports.add(report1);

        SurveyReport report2 = new SurveyReport();
        report2.setSurveyId(2);
        report2.setEmployeeName("Bob");
        report2.setLocation("Mumbai");
        report2.setTotal_connection_request(150);
        report2.setNo_of_days_for_request_completion(15);
        report2.setAverage_request_per_day(10);
        reports.add(report2);
        
        Stream<SurveyReport> surveystream = reports.stream();
        SurveyReport maxRequests = surveystream.min((d1,d2)-> {
        	if(d1.getTotal_connection_request() == d2.getTotal_connection_request()) {
        		return 0;
        	}
        	else if(d1.getTotal_connection_request() > d2.getTotal_connection_request()) {
        		return 1;
        	}
        	else return -1;
        }).get();
//        
//        System.out.println("Maximum no. of requests: " + maxRequests);
        
//        int delhiCount = (int) reports.stream()
//                .filter(report -> report.getLocation().equalsIgnoreCase("Delhi"))
//                .count();
//        System.out.println("Location count for Delhi: " + delhiCount);
        
//        int AverageTimeForRequestCompletion=reports.stream()
//        .map((e)->e.getNo_of_days_for_request_completion())
//        .reduce(0,(a,b)->a+b);
//        System.out.println("Average time for request completion: " + AverageTimeForRequestCompletion);
        
//        int totalAverageRequestsPerDay = (int)reports.stream()
//                .mapToInt(SurveyReport::getAverage_request_per_day)
//                .average()
//                .orElse(0);
//        System.out.println("Total average request per day: " + totalAverageRequestsPerDay);
       
    }
}