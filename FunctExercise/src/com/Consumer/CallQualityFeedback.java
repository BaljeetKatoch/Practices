package com.Consumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CallQualityFeedback {
    int customerId;
    String phoneNo;
    String feedBackDescription;
    int rating;

    public CallQualityFeedback(int customerId, String phoneNo, String feedBackDescription, int rating) {
        this.customerId = customerId;
        this.phoneNo = phoneNo;
        this.feedBackDescription = feedBackDescription;
        this.rating = rating;
    }

    public void evaluateFeedback(Consumer<CallQualityFeedback> consumer, Predicate<CallQualityFeedback> predictor) {
        consumer.accept(this);
        if (predictor.test(this)) {
            System.out.println("Call quality is good.");
        } else {
            System.out.println("Call quality is bad.");
        }
    }
    }