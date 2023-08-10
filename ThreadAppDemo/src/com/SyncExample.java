package com;

class PrintNames implements Runnable
{
    String[] names = {"Peter", "Sam", "Edgar", "Mathew", "Simond"};
    
    public synchronized void printArray()
    {
        for(String s : names)
        {
            System.out.println(s);
        }
    }

    
    public void run()
    {
    	printArray();
    }
}

public class SyncExample
{
    public static void main(String[] args)
    {
        PrintNames printNames = new PrintNames();
        
        Thread thread = new Thread(printNames);
        Thread thread2 = new Thread(printNames);
        thread.start();
        thread2.start();
    }
}
