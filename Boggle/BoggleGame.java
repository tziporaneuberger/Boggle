
public class BoggleGame 
{
	public static void main (String [] args)
	{
		System.out.println("Welcome to Boggle!");
		System.out.println("Please choose from the following options:\n "+
				           "1.New round\n2.Quit the game" );
		
		BoggleBoard board = new BoggleBoard();
		
		char [][] theBoard = board.newBoard();
		
		for (int j= 0; j< theBoard.length; j++)
		{
			System.out.println("\n");
			for (int k = 0; k< theBoard[1].length; k++)
			{  
				
				if (theBoard[j][k] == 'q')
				{
					System.out.printf("  qu");
				}
				else
				{
				System.out.printf("   " + theBoard[j][k]);
				}
			}
		}
		
	}

}
