package com.charapp;
import java.io.*;

public class SaveToFile {

	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt"))) {
            writer.write("Employee Name: Peter Sam Joes");
            writer.newLine();
            writer.write("Department: Sales");
            writer.newLine();
            writer.write("Designation: Manager");
            writer.newLine();
            writer.write("Salary: 35000");
            System.out.println("Values saved to employee.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
		try (BufferedReader reader = new BufferedReader(new FileReader("employee.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);

	}
	}
}
