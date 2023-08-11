package com.ref;

import java.util.function.Predicate;

class Candidate {
    public boolean checkAge(int age) {
        return age > 18;
    }
}

public class AgePredicateExample {
    public static void main(String[] args) {
        Candidate candidate = new Candidate();
        
        int[] agearray = {12, 23, 11, 19, 35, 22};

        Predicate<Integer> ageCheckPredicate = candidate::checkAge;

        for (int age : agearray) {
            if (ageCheckPredicate.test(age)) {
                System.out.println("Valid age");
            } else {
                System.out.println("Invalid age");
            }
        }
    }
}
