import java.util.Random;
public class BoggleBoard 
{
	public BoggleBoard()
	{
	}
	
	int rows = 5;
	int columns = 5;
	
	public char [][] newBoard()
	{
	
	//initialize double array 
	char boggle[][]= new char [rows][columns];
	
	 for(int l = 0; l< boggle.length; l++) {
		
		 for( int w= 0; w< boggle[l].length; w++) {
			 Random r = new Random();
			 char c = (char) (r.nextInt(26) + 'a');
			 
				 
			 boggle[l][w] = c;
			 
		 }
	 }
	 
	 return boggle;
	
	
}}

