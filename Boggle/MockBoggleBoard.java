
public class MockBoggleBoard implements IBoggleBoard
{
   private char [][] board;
   
   public MockBoggleBoard()
   {
	   board = new char [5][5];
	  
   }
   
   public void makeBoard()
   {
	   
   }
   
   public void setBoard(char [][] board)
   {
	   this.board = board;
   }
   
   public char[][] getBoard()
   {
	   return board;
   }
}
