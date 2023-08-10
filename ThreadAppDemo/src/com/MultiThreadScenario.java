package com;

class UserDetailsThread extends Thread {
    private String userName;

    public UserDetailsThread(String userName) {
        this.userName = userName;
    }

    public void run() {
        try {
            Thread.sleep(5000);

            System.out.println("Hello, " + userName + "!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CountThread extends Thread {
    public void run() {
        int count = 1;
        while (true) {
            System.out.println("Count: " + count);
            count++;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
                break;
            }
        }
    }
}

public class MultiThreadScenario {
    public static void main(String[] args) {
        UserDetailsThread userDetailsThread = new UserDetailsThread("Erric");
        CountThread countThread = new CountThread();

        userDetailsThread.start();
        countThread.start();
        try {
            userDetailsThread.join(); 
            countThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
       

    }
}
