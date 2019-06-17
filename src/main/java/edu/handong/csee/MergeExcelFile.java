package edu.handong.csee;

import java.util.ArrayList;

import edu.handong.csee.utils.ZipReader;
import edu.handong.csee.utils.NotEnoughArgumentException;
import edu.handong.csee.utils.OutputWrite;

public class MergeExcelFile {
	
	public void run(String[] args)
	{
		try {
			if(args.length<2)
				throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) {
			System.out.println(e.getMessage());	
			System.exit(0);
		}
		
		String input=args[0];
		String output=args[1];
		
		ArrayList<String> mergefile=ZipReader.readFileInZip(input);
		OutputWrite.writeAFile(mergefile,output);
	}
}