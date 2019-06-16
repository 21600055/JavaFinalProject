package edu.handong.csee;

import edu.handong.csee.utils.*;

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
		
	}
}
