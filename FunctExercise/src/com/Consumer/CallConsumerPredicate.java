package com.Consumer;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class CallConsumerPredicate {
    public static void main(String[] args) {
        CallQualityFeedback feedback = new CallQualityFeedback(1, "1234567890", "Good call experience", 5);
        CallQualityFeedback feedback1 = new CallQualityFeedback(2, "9324567890", "Moderate call experience", 3);

        Consumer<CallQualityFeedback> feedbackConsumer = feedbackObj -> {
            System.out.println("Customer ID: " + feedbackObj.customerId);
            System.out.println("Phone No: " + feedbackObj.phoneNo);
            System.out.println("Feedback Description: " + feedbackObj.feedBackDescription);
            System.out.println("Rating: " + feedbackObj.rating);
        };
        
        Predicate<CallQualityFeedback> qualityPredictor = feedbackObj -> feedbackObj.rating > 3;


        feedback.evaluateFeedback(feedbackConsumer, qualityPredictor);
        feedback1.evaluateFeedback(feedbackConsumer, qualityPredictor);
    }
}
