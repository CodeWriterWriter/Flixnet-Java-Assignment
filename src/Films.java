


public class Films {
	
	
	private String id;
	private String title;
	private String year;
	private String genre;
	
	public Films(String id, String title, String year, String genre)
	{
		this.id  = id;
		this.title = title;
		this.year = year;
		this.genre  = genre;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getId()
	{
		return id;
	}
	public String getTitle()
	{
		return title;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public String toString()
    { 
    	return   "ID: " + id + ", Film Title: " + title + ", Film Year: " + year + ", Film Genre: " + genre;
    	
    }
	
	public String filmsCsvfile(){
		
		return id + "," + title + "," + year + "," + genre;
		
	}
}
