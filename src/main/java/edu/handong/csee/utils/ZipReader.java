package edu.handong.csee.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {

	public static ArrayList<String> readFileInZip(String path) {
		ZipFile zipFile;
		ArrayList<String> mergeFile= new ArrayList<String>();
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        String stdId=path.substring(0,4);
		        mergeFile.addAll(myReader.getData(stream,stdId));
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {
			
			PrintWriter outputStream = null;
			
			try {
				outputStream = new PrintWriter("error.csv");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			outputStream.println(path);
			outputStream.close();
		}
		return mergeFile;
	}
}