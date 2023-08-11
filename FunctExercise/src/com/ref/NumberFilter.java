package com.ref;

import java.util.function.Predicate;

public class NumberFilter {
    public static void main(String[] args) {
        int[] arr = {12, 23, 11, 19, 25, 32, 16, 22};

        Predicate<Integer> evenNumberFilter = NumberFilter::isEven;

        for (int num : arr) {
            if (evenNumberFilter.test(num)) {
                System.out.println("Even number: " + num);
            }
        }
    }
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
