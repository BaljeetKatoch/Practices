package com.waitnotify;

class Cab {
    String cabDriverName;
}
class waitingThread implements Runnable
{
	Cab cab;
	String cabDriverName;
	public waitingThread(Cab cab, String cabDriverName)
	{
		this.cab=cab;
		this.cabDriverName=cabDriverName;
	}
	public void run()
	{
	 synchronized (cab) {
         try {
             System.out.println("Waiting for 5 seconds...");
             cab.wait(5000); 
             System.out.println("Done waiting!");
         } catch (InterruptedException e) {
             System.out.println(e);
         }
	 }
}
}
class notifyingThread implements Runnable
{
	Cab cab;
	notifyingThread(Cab cab)
	{
		this.cab=cab;
	}
	public void run()
	{
		synchronized(cab) 
		{
		try {
        Thread.sleep(5000);
        cab.notify();
    } catch (InterruptedException e) {
        System.out.println(e);
    }
}
}
}
public class CabExercise 
{
    public static void main(String[] args) 
    {
        Cab cab1 = new Cab();
        waitingThread waiting1 = new waitingThread(cab1,"Alex");
        notifyingThread notifying1 = new notifyingThread(cab1);
        Thread t1=new Thread(waiting1);
        Thread t2=new Thread(notifying1);
        t1.start();
        t2.start();
    }
}