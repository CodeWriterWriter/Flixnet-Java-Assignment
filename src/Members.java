

public class Members {
	
	protected String username;
	protected String firstName;
	protected String surname;
	protected String password;
	//protected static ArrayList<Members> allMembers;
	
	public Members(String username,String firstName, String surname,  String password )
	{
		this.username = username;
		this.firstName = firstName;
		this.surname  = surname;
		this.password = password;
		//allMembers = new ArrayList<Members>();
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	protected  String getPassword()
	{
		return password;
	}
	
	 public String toString()
	    { 
		 return "Username:" + username + ", First Name:" + firstName +", Surname:" + surname + ", Password:" + password;
	    	
	    }

		
	public String membersCsvfile(){
		
		return username + "," + firstName + "," + surname + "," + password;
		
	}
}

	
		
