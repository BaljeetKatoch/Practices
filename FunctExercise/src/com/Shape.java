package com;

interface Area {
    void calculateArea(int sides);
}

public class Shape {
    public void calculateAndPrintArea(Area areaCalculator, int sides) {
        areaCalculator.calculateArea(sides);
    }

    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.calculateAndPrintArea(sides -> {
            int area = sides * sides; 
            System.out.println("Area of the shape: " + area);
        }, 4);
    }
}

