package com.serial;
import java.io.*;
public class CallQualityCollection {

	public void saveCallQuality(CallQuality callQuality)
	{
		 try {
		FileOutputStream fileout=new FileOutputStream(callQuality.getcallId()+".dat");
		 ObjectOutputStream objectout=new ObjectOutputStream(fileout);
		 objectout.writeObject(callQuality);
		 objectout.flush();
		 objectout.close();
		 }
		 catch(FileNotFoundException e)
		 {
			 System.out.println(e);
		 }
		 catch(IOException e1)
		 {
			 System.out.println(e1);
		 }
	}
	public void displayCallQuality(int callId)
	{
		
		try {
			FileInputStream filein =new FileInputStream(callId+".dat");
			ObjectInputStream objectin=new ObjectInputStream(filein);
			CallQuality callQuality =(CallQuality)objectin.readObject();
			
			System.out.println("Call ID: "+callQuality.getcallId());
			System.out.println("Call Duration:  "+callQuality.getcallDuration());
			System.out.println("Call Quality Grade: "+callQuality.getcallQualityGrade());
			System.out.println("Customer Name: "+callQuality.getcustomerName());
		}
		catch(FileNotFoundException e1)
		{
			System.out.println(e1);
		}
		catch(IOException e2)
		{
			System.out.println(e2);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
CallQuality obj1=new CallQuality(1,600,"Best","Peter");

CallQualityCollection records=new CallQualityCollection();

records.saveCallQuality(obj1);
records.displayCallQuality(obj1.getcallId());
	}

}