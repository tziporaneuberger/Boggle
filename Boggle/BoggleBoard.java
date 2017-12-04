
import java.util.ArrayList;
import java.util.Random;

public class BoggleBoard {

	char[][]boggle;
	char[][] board;
	int num;//the number of rows

	public BoggleBoard(){   // missing q, need to fix the dice letter options , and a way to "mix up the dice"
		this.boggle= new char [][]{{'a', 'r', 't','l','e','d'}, 
			{'f','o','g','s','k','w'},
			{'r','h','e', 'c', 't','m'}, {'n', 'u', 'a','b','i','y'},{'o', 'r', 'p','l','a','d'}, {'f','o','g','s','k','w'},
			{'b','h','a', 'h', 't','n'}, {'n', 'e', 'w','b','d','y'},{'a', 'j', 't','c','i','d'}, {'f','o','g','s','k','w'},
			{'f','h','e', 'g', 'v','m'}, {'n', 'o', 'd','m','i','x'},{'a', 'r', 's','l','e','k'}, {'f','o','g','s','k','w'},
			{'a','h','e', 'c', 'z','d'}, {'c', 'u', 'y','b','i','j'}};
			num=4;
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


