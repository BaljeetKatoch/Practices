package com.mystream;

import java.util.stream.*;

public class Prime {
    public static void main(String[] args) {
        Stream<Long> primeStream = Stream.generate(new PrimeNumberGenerator());
        primeStream.limit(10).forEach(System.out::println);
    }
}

class PrimeNumberGenerator implements java.util.function.Supplier<Long> {
    private long current = 2;

    @Override
    public Long get() {
        while (!isPrime(current)) {
            current++;
        }
        long prime = current;
        current++;
        return prime;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
