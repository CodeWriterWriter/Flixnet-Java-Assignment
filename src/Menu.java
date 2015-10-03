import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Menu {
	private ArrayList<Member> members;
	private ArrayList<Rating> ratings;
	private ArrayList<Movie> movies;
	
	public Menu()
	{
		
	}
	
	public void addMember(Member newMember)
	{
		members.add(newMember);
	}
	
	public void addRating(Rating newRating)
	{
		ratings.add(newRating);
	}
	
	public void addMovie(Movie newMovie)
	{
		movies.add(newMovie);
	}
	
	public ArrayList<Member> getMembers()
	{
		return members;
	}
	
	public ArrayList<Rating> getRatings()
	{
		return ratings;
	}
	
	public ArrayList<Movie> getMovies()
	{
		return movies;
	}
	
	private void read() throws IOException
	{
		try 
		{
		    POIFSFileSystem films = new POIFSFileSystem(new FileInputStream("films_fx.csv"));
		    HSSFWorkbook wb = new HSSFWorkbook(films);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0;
		    int tmp = 0;

		    for(int i = 0; i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 0; r < rows; r++) 
		    {
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		        	int id = (Integer) null;
		        	String title = null;
		        	int year = (Integer) null;
		        	String genre = null;
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell(c);
		                if(cell != null) 
		                {
		                	if (c == 1)
		                	{
		                		id = (int) cell.getNumericCellValue();
		                	}
		                	
		                    if (c == 2)
		                    {
		                    	title = cell.getStringCellValue();
		                    }
		                    if (c == 3)
		                    {
		                    	year = (int) cell.getNumericCellValue();
		                    }
		                    if (c == 4)
		                    {
		                    	genre = cell.getStringCellValue();
		                    }
		                }
		            }
		            Movie newFilm = new Movie(id, title, year, genre);
		            movies.add(newFilm);
		        }
		    }
		} catch(Exception ioe) 
		{
		    ioe.printStackTrace();
		}
	}

}
