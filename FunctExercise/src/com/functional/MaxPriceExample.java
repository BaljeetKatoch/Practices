package com.functional;

import java.util.function.*;
import java.util.*;
public class MaxPriceExample {
    public static void main(String[] args) {
        Item item1 = new Item("Item 1", 25.99);
        Item item2 = new Item("Item 2", 19.99);
        Item item3 = new Item("Item 3", 34.99);

        BinaryOperator<Item> maxPriceOperator = BinaryOperator.maxBy(
            (itemA, itemB) -> Double.compare(itemA.getPrice(), itemB.getPrice())
        );
        Item itemWithMaxPrice = maxPriceOperator.apply(
                maxPriceOperator.apply(item1, item2),
                item3
            );
        System.out.println("Item with max price: " + itemWithMaxPrice.getName() + " - " + itemWithMaxPrice.getPrice());
    }
}