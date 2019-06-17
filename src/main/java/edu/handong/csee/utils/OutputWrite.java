package edu.handong.csee.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OutputWrite {
	
	public static void writeAFile(ArrayList<String>mergefile,String targetFileName)
	{
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(targetFileName);
		} catch(FileNotFoundException e) {
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		}
		int i;

		for(i=0;i<mergefile.size();i++)
		{
			outputStream.println(mergefile.get(i));
		}
		outputStream.close();
	}
}
