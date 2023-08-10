package com.byteapp;

import java.io.*;

public class BugInfoReader {

	public static void main(String[] args) {
		try {
			
			
			FileInputStream fin=new FileInputStream("buginfo.dat");
			byte[] bt=new byte[200];
			fin.read(bt);
			for(byte b:bt)
			{
				System.out.print((char)b);
			}
			
		}
		catch(IOException ex)
		{
			System.out.println("IO error "+ex);
		}

	}

}
