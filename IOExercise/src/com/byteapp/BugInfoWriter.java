package com.byteapp;

import java.io.*;
import java.util.Scanner;

public class BugInfoWriter {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

            System.out.print("Enter developer name: ");
            String developerName = scanner.nextLine();
            System.out.println("Developer Name: " + developerName);

            System.out.print("Enter bug number: ");
            String bugNumber = scanner.nextLine();
            System.out.println("Bug Number: " + bugNumber);

            System.out.print("Enter bug description: ");
            String bugDescription = scanner.nextLine();
            System.out.println("Bug Description: " + bugDescription);

            System.out.println("Bug information stored in buginfo.dat");    
			FileInputStream writer = new FileInputStream("buginfo.dat");
	            
		}
		catch(IOException ex)
		{
			System.out.println("IO error "+ex);
		}

	}

}
