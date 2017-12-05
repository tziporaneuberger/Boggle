
import java.util.ArrayList;
import java.util.Random;

public class BoggleBoard {

	char[][]boggle;
	char[][] board;
	int num;//the number of rows

	public BoggleBoard(){   
		this.boggle= new char [][]{
			{'A', 'A', 'E','E','E','E'},{'A','A','A','F','R','S'},{'A','A','F', 'I', 'R','S'}, {'A', 'D', 'E','N','N','N'},{'A', 'E', 'E','E','E','M'},
			{'A','E','E','G','M','U'},{'A','E','G', 'M', 'N','N'}, {'A', 'F', 'I','R','S','Y'},{'B', 'J', 'K','Q','X','Z'}, {'C','C','N','S','T','W'},
			{'C','E','I', 'I', 'L','T'}, {'C', 'E', 'I','L','P','T'},{'C', 'E', 'I','P','S','T'}, {'D','D','L','N','O','R'},{'D','H','H', 'L', 'O','R'},
			{'E', 'I', 'I','I','T','T'} , {'D','H','H','N','O','T'},{'D', 'H', 'L','N','O','R'},{'E', 'M', 'O','T','T','T'},{'E', 'N', 'S','S','S','U'},
			{'F', 'I', 'P','R','S','Y'},{'G', 'O', 'R','R','W','V'},{'H', 'I', 'P','R','R','Y'},{'N', 'O', 'O','T','U','W'},{'O', 'O', 'O','T','T','U'}};
			num=5;
		this.board=new char[num][num];
	}
	
	
	
	// chooses a random dice for each position - using an array list to represent all the positions
	// once the index of a dice is chosen it is removed from the array list - so it leaves an ever shrinking array list.
	// when it falls out the loop, all the dice are used.
	public void getBoard(){
		  ArrayList<Integer> availIndexes=new ArrayList<Integer>(num*num);
		  for (int i=0; i<(num*num); i++){
		   availIndexes.add(i);
		  }
		  Random r=new Random();
		  int randomIndex;
		  int rowIndex;
		  for (int row=0; row<num; row++){
		   for (int column=0; column<num; column++ ){
		    rowIndex=r.nextInt(availIndexes.size());
		    randomIndex=r.nextInt(6);
		    board[row][column]=boggle[availIndexes.get(rowIndex)][randomIndex];
		    availIndexes.remove(rowIndex);
		   }
		  }
		 }
	

	@Override
	public String toString(){
		char letter;
		StringBuilder display=new StringBuilder();
		for(int r = 0; r< board.length; r++) {
			display.append("\n");
			for( int c= 0; c< board[r].length; c++) {
				
				if (board[r][c] == 'q')
				{
					display.append(" qu");
				}
				else
				{
				letter=board[r][c];
				display.append("  " + letter);
				}
			}
		}
		return display.toString();
	}

}


