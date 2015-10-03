import java.util.ArrayList;


public class Flixnet {
	private static ArrayList<Members> allMembers;
	private static ArrayList<Ratings> rate;
	private static ArrayList<Films> movies;
	private String loggedin;
	
	public Flixnet() {
		allMembers = new ArrayList<Members>();
		rate = new ArrayList<Ratings>();
		movies = new ArrayList<Films>();
	
	}
	
	public ArrayList<Members> getAllMembers() {
		return allMembers;
	}

	//public void setPlayers(ArrayList<Members> members) {
		//members = new ArrayList<Members>();
	//}
	
	public void setlogged(String loggedin)
	{
		this.loggedin = loggedin;
	}
	
	public String getloggedin()
	{
		return loggedin;
	}
	
	public void listFilms(){
		int i = 0;
		for (i = 0; i < movies.size(); i++) {
			StdOut.println(i + ":" + movies.get(i));
		}
	}
	
	public void listMembers() {
		int i = 0;
		for (i = 0; i < allMembers.size(); i++) {
			StdOut.println(i + ":" + allMembers.get(i));
			}
	}
	
	public void listRatings(){
		int i = 0;
		for (i = 0; i < rate.size(); i++){
			StdOut.println(i + ":" + rate.get(i));
			
		}
	}
	
	public void editMember() {
		listMembers();
		StdOut.print("PLease enter the index number of the staff member you wish to edit ==>");
	      int index = StdIn.readInt();
	      Members members = allMembers.get(index);
	      
	      StdOut.print("Enter new Username: ");
	      String newUsername = StdIn.readString();
	      members.setUsername(newUsername);
	  
	      StdOut.print("Enter new First Name: ");
	      String newFirstName = StdIn.readString();
	      members.setFirstName(newFirstName);
	      
	      StdOut.print("Enter new Surname: ");
	      String newSurname = StdIn.readString();
	      members.setSurname(newSurname);
	      
	      StdOut.print("Enter new Password: ");
	      String newPassword = StdIn.readString();
	      members.setPassword(newPassword);
	      saveMembers();
		}
	
	public void deleteMember() {
		listMembers();
		StdOut.print("Please enter the index number of the Member you wish to delete ==>");
		int index = StdIn.readInt();
		if (index >= 0 && index < allMembers.size())
			allMembers.remove(index);
		saveMembers();
	}
	
	public void deleteFilm() {
		listFilms();
		StdOut.print("Please enter the index number of the Film you wish to delete ==>");
		int index = StdIn.readInt();
		if (index >= 0 && index < movies.size())
			movies.remove(index);
		saveFilms();
	}
	
	 public void editFilm()
	    {
	      listFilms();
	      StdOut.print("Select Film Position To Edit");
	      int index = StdIn.readInt();
	      Films films = movies.get(index);
	      
	      StdOut.print("Enter new ID: ");
	      String newID = StdIn.readString();
	      films.setID(newID);
	  
	      StdOut.print("Enter new title: ");
	      String newTitle = StdIn.readString();
	      films.setTitle(newTitle);
	      
	      StdOut.print("Enter new year: ");
	      String newYear = StdIn.readString();
	      films.setYear(newYear);
	      
	      StdOut.print("Enter new genre: ");
	      String newGenre = StdIn.readString();
	      films.setGenre(newGenre);
	      saveFilms();
	    }
	
	public static void loadMembers() {
		
		In in= new In("members.csv");
		String delims= "[,]";
		while(!in.isEmpty()) {
		String[] data= in.readLine().split(delims);
		Members members= new Members(data[0], data[1], data[2], data [3]);
		allMembers.add(members);
		}
		in.close();
}
	public static void saveMembers(){
	Out out = new Out("members.csv");
	for (Members member:allMembers){
	out.println(member.membersCsvfile());
	}
	out.close();
	}
	
	public static void loadFilms() {
		In in = new In("films.csv");
		String delims = "[,]";
		while(!in.isEmpty()) {
		String[] data = in.readLine().split(delims);
		Films films = new Films(data[0], data[1], data[2], data[3]);
		movies.add(films);
		}
		in.close();
	}
	
	public static void saveFilms(){
		Out out = new Out("films.csv");
		for (Films film:movies){
		out.println(film.filmsCsvfile());
		}
		out.close();
		}
	
	private void addMember() {
		
		StdOut.print("Please Choose a Username : ");
		String username = StdIn.readString();
		
		StdOut.print("Please Enter Your First Name : ");
		String firstName = StdIn.readString();
		
		StdOut.print("Please Enter Your Surname: ");
		String surname = StdIn.readString();
		
		StdOut.print("Please Choose a Password : ");
		String password = StdIn.readString();
		
		Members member = new Members(username, firstName, surname, password);
		allMembers.add(member);
		saveMembers();
		
	}
	
	public void addFilm()
    {
   	 	StdOut.print("Enter a Film ID:");
        String ID = StdIn.readString();
      
        StdOut.print("Enter the Film Name:");
        String title = StdIn.readString();
     
        StdOut.print("Enter the year of the Film:");
        String year = StdIn.readString();
     
	   	StdOut.print("Enter the Genre of the Film: ");
	   	String genre = StdIn.readString();
	   	 
	   	Films films = new Films(ID, title, year, genre);
	   	movies.add(films);
	   	saveFilms();
    }
	
	public static void main(String[] argvs) {
		Flixnet app = new Flixnet();
		loadMembers();
		//loadRatings();
		loadFilms();
		app.run();
	}
	private int mainMenu() {
		StdOut.println("WELCOME TO FLIXNET");
		StdOut.println("------------------");
		StdOut.println("  1) LOG IN");
		StdOut.println("  2) REGISTER FOR NEW ACCOUNT");
		StdOut.println("  3) STAFF");
		StdOut.println("-----------------------------");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}
	
	private int userMenu() {
		StdOut.println("WELCOME" + " " + loggedin);
		StdOut.println("------------------");
		StdOut.println("  1) Show Account Details");
		StdOut.println("0) Log Out");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
		
	}
	
	private int staffMenu() {
		StdOut.println("STAFF MENU");
		StdOut.println("------------------");
		StdOut.println("  1)  Staff Movies Options");
		StdOut.println("  2)  Staff Members Options");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}
	
	
	private void run() {
		
		int option = mainMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				userLogIn();
				break;
			case 2:
				addMember();
				break;
			case 3:
				staffMenuOptions();
				break;
			}

			option = mainMenu();
		}
		StdOut.println("Exiting... bye");
	}
	
	public void listMovieYear(){ 
		  System.out.println("Enter a year: ");	
		  String inputYear = StdIn.readString();
		 
		  for (Films film: movies){
			if((inputYear.equals(film.getYear())))
			{
				System.out.println(film);
			
			}
		
	}
	}
	
	public void loggedInDetails(){ 
		
			for (Members member: allMembers){
			if (this.loggedin.equals(member.getUsername()))
			{
				System.out.println(member);
			
			}
		
	}
	}
	public void userLogIn(){
		
		boolean isMember = false;
		
		System.out.println("Enter username: ");
	    String inputUsername = StdIn.readString();
	    System.out.println("Enter password: ");
	    String inputPassword = StdIn.readString();
	    for (Members member: allMembers){
	    	isMember = false;
			if((inputUsername.equals(member.getUsername())) && (inputPassword.equals(member.getPassword())))
			{
				this.loggedin=member.username;
				userMenuOptions();
				isMember= true;
				
					
				
			}
	    }
			 if(!isMember)
				 isMember = false;
			    	StdOut.println("Login error. Try Again");
	    
	}
	
	
private void staffMenuOptions() {
		
		int option = staffMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				 staffFilmOptions();
				break;
			case 2:
				staffMembersOptions();
				break;
			}
			option = staffMenu();
		}
		StdOut.println("Exiting... bye");
	}

	private int staffFilmsMenu() {
		StdOut.println("STAFF FILM OPTIONS");
		StdOut.println("------------------");
		StdOut.println("  1)  List all Films");
		StdOut.println("  2)  Add a Film");
		StdOut.println("  3)  Edit a Film");
		StdOut.println("  4)  Delete a Film");
		StdOut.println("  5)  Return to Staff Main Menu");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}
	
	private void staffFilmOptions() {
		int option = staffFilmsMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				listFilms();
				break;
			case 2:
				addFilm();
				break;
			case 3:
				editFilm();
				break;
			case 4:
				deleteFilm();
				break;
			case 5:
				staffMenuOptions();
				break;
			}
			
			option = staffFilmsMenu();
		}
		
	}
	
	private int staffMembersMenu() {
		StdOut.println("MEMBERS MENU FOR STAFF");
		StdOut.println("------------------");
		StdOut.println("  1)  List all Members");
		StdOut.println("  2)  Add a Member");
		StdOut.println("  3)  Edit a Member");
		StdOut.println("  4)  Delete a Member");
		StdOut.println("  5)  Return to Staff Main Menu");
		StdOut.println("0) Exit");
		StdOut.print("==>>");
		int option = StdIn.readInt();
		return option;
	}
	
	private void staffMembersOptions() {
		int option = staffMembersMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				listMembers();
				break;
			case 2:
				addMember();
				break;
			case 3:
				editMember();
				break;
			case 4:
				 deleteMember();
				break;
			case 5:
				staffMenuOptions();
				break;
			}
			
			option = staffMembersMenu();
		}
		
	}
	
	private void userMenuOptions() {
		
		int option = userMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				loggedInDetails();
				break;
			case 2:
				
				break;
			case 3:
				editFilm();
				break;
			case 4:
				listMovieYear();
				break;
			case 5:
				listMembers();
				break;
			case 6:
				
				break;
			
			}

			option = userMenu();
		}
		
		StdOut.println("Logged Out");
	}
	

}
