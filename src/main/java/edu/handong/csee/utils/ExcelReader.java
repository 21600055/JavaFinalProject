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
	
	public ArrayList<String> getData(InputStream is) {
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
		        	if(row!=null)
		        	{
		        		int cells=row.getPhysicalNumberOfCells();
		        		for(int columnIndex=0;columnIndex<cells;columnIndex++)
		        		{
		        			cell=row.getCell(columnIndex);
		        			String value=null;
		        			
		        			switch(cell.getCellType())
		        			{
		        			   case NUMERIC:
		        				   value=Double.toString(cell.getNumericCellValue());
		        				   break;
		        			   case STRING:
		        				   value=cell.getStringCellValue();
		        				   break;
		        			   default:
		        				   break;
		        			}
		        			values.add(value);
		        		}
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