package com;

import java.util.Scanner;

class UserInputThread extends Thread {
    private String name;
    private String email;

    public UserInputThread(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void run() {
        System.out.println("User: " + name + ", Email: " + email);
    }
}

class SimpleInterestThread extends Thread {
    private double principal;
    private double rate;
    private double time;

    public SimpleInterestThread(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public void run() {
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter principal, rate, and time:");
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double time = scanner.nextDouble();

        scanner.close();

        UserInputThread userInputThread = new UserInputThread(name, email);
        SimpleInterestThread simpleInterestThread = new SimpleInterestThread(principal, rate, time);

        userInputThread.start();
        simpleInterestThread.start();
    }
}
