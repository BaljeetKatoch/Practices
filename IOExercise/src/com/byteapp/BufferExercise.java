package com.byteapp;
import java.io.*;
public class BufferExercise {

	public static void main(String[] args) {
		String developerName="William";
		String bugNo="123";
		String bugDescription="Application crashes";
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("buginfo.txt"))) {
            String data = "Developer Name: " + developerName + "\n"
                    + "Bug No: " + bugNo + "\n"
                    + "Bug Description: " + bugDescription;

            byte[] bytes = data.getBytes();
            bos.write(bytes);
        } catch (IOException e) {
            System.out.println(e);
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("buginfo.txt"))) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                String content = new String(buffer, 0, bytesRead);
                System.out.print(content);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

	}

}
