package com.mystream;

import java.util.stream.Stream;

public class Builder {
    public static void main(String[] args) {
        Stream<String> valueStream = Stream.<String>builder()
                .add("BaudeRate")
                .add("Ohm")
                .add("Kilowatt")
                .add("Bits")
                .add("Analog")
                .add("Digital")
                .build();

        valueStream.forEach(System.out::println);
    }
}
