
public class Ratings{ //extends Members {

	protected int score;
	
	public Ratings (int score) 
	{
		//super(username, firstName, surname, password);
		this.score = score;
	}
	
	public void setscore(int score)
	{
		this.score = score;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String toString()
    { 
    	return   "Score" + score;
    	
    }
}