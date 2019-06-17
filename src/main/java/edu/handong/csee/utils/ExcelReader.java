package edu.handong.csee.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public ArrayList<String> getData(InputStream is,String stdId) {
		ArrayList<String> values = new ArrayList<String>();
		
		try (InputStream inp = is) {
		    
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        int rows=sheet.getPhysicalNumberOfRows();
		        Row row;
		        Cell cell;
		        for(int rowIndex=0;rowIndex<rows;rowIndex++)
		        {
		        	row=sheet.getRow(rowIndex);
		        	String rvalue=stdId+",";
		        	if(row!=null)
		        	{
		        		int cells=row.getPhysicalNumberOfCells();
		        		for(int columnIndex=0;columnIndex<cells;columnIndex++)
		        		{
		        			cell=row.getCell(columnIndex);
		        			String value="";

		        			switch(cell.getCellType())
		        			{
		        			   case NUMERIC:
		        				   value=Double.toString((int) cell.getNumericCellValue());
		        				   rvalue=rvalue+value+",";
		        				   break;
		        				   
		        			   case STRING:
		        				   value=cell.getStringCellValue();
		        				   if(value.contains(","))
		        				   {
		        					   rvalue=rvalue+"\"" +value+ "\""+",";
		        					   break;
		        				   }
		        				   if(value.contains("\n"))
		        				   {
		        					   rvalue=rvalue+"\""+value+"\""+",";
		        					   break;
		        				   }
		        				   rvalue=rvalue+value+",";
		        				   break;
		        			   case BLANK:
		        				 
		        				   value="";
		        				   rvalue=rvalue+value+",";
		        				   break;
							
		        			   default:
								break;
		        			}
		        		}
		        		values.add(rvalue);
		        	}
		         }  
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
		    	System.out.println("The file path does not exist. Please check your CLI argument!");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return values;
	}
}