
import java.util.ArrayList;
public class FindWords {

	private static char[][] board;
	private ArrayList<String> words;
	private static boolean [] wordFound;
	private static int [][] rowColIncrement;

	public FindWords(IBoggleBoard b, ArrayList<String> words){
		board=b.getBoard();
		this.words=words;
		rowColIncrement=new int[8][2];
		rowColIncrement[0][0] = 1;           rowColIncrement[0][1] = -1;
		rowColIncrement[1][0] = 1;           rowColIncrement[1][1] = 1;
		rowColIncrement[2][0] = 1;           rowColIncrement[2][1] = 0;
		rowColIncrement[3][0] = 0;           rowColIncrement[3][1] = -1;
		rowColIncrement[4][0] = 0;           rowColIncrement[4][1] = 1;
		rowColIncrement[5][0] = -1;          rowColIncrement[5][1] = -1;
		rowColIncrement[6][0] = -1;          rowColIncrement[6][1] = 1;
		rowColIncrement[7][0] = -1;          rowColIncrement[7][1] = 0;	
		wordFound = new boolean [words.size()];
	}
	
	//This method fills up an array of true/false values for each word on the list, for whether or not it is on the board
	public void fillInTruthArray(){
		for(int i=0; i<words.size(); i++){
			if (words.get(i).isEmpty()){
				wordFound[i]=false;
			}
			else if (words.get(i). length() < 3){
				wordFound[i]= false;
			}
			else{
			wordFound[i]= findAWord(words.get(i), 0, 0);
			}
		}
	}

	public boolean findAWord(String word, int row, int col){
		Point firstLetterPoint= findFirstLetter(word.charAt(0), row, col);
		int firstLetterRow = firstLetterPoint.getRow();
		int firstLetterColumn = firstLetterPoint.getCol();
		boolean found;
		
		if (word.contains("QU")){
			int index = word.indexOf('Q');
			String wordBegin = word.substring(0, index+1);
			word= wordBegin + word.substring(index+2);
		}
             
		    //first letter was found on board, so check for more letters
			if ( firstLetterRow != -1)
			{    
				found = makeNextDecision(0,firstLetterRow,firstLetterColumn, word);
				
				//found first letter, but other letters not near it, so look for word again,starting from the location after where you found the letter the previous time.
				if (found == false){     
					found=findAWord(word, firstLetterRow, firstLetterColumn);
				}
				return found;
			}
			
			// first letter was not found on board
			else{
				return false;
			}
	}
	
	

	public Point findFirstLetter(char c, int beginRow, int beginCol){
		int col;
		if (beginRow !=0 || beginCol != 0){
			col= beginCol+1;
		}
		else{
			col= beginCol;
		}
		int row=beginRow;
		while(col<5){
			if (board[row][col] == c){
				return new Point(row, col);
			}
			else{
				col++;
			}		
		}
		for (row=beginRow+1; row<board.length; row++){
			for (col=0; col<board[row].length; col++){
					if(c==board[row][col]){
					return new Point(row, col);
				  }
			}
		}
		return new Point(-1, -1);
	}

	
	
    
	public boolean makeNextDecision(int lastCharAt, int fromRow, int fromCol, String s)
	{  
		int thisCharAt = lastCharAt + 1;
		int numberOfChoices =8;
		int choiceNumber =0;
		boolean atGoal = false;

		while (atGoal == false && choiceNumber < numberOfChoices)
		{
			int row = nextChoiceRow(choiceNumber,fromRow);
			int col = nextChoiceColumn(choiceNumber,fromCol);
			if (thisDecisionChoiceIsValid (row,col) && board[row][col]== s.charAt(thisCharAt))
			{ 
					if (goalHasBeenReached(thisCharAt, s))
					{
						return true;
					}
					
					atGoal = makeNextDecision(thisCharAt,row,col, s);
			}

			choiceNumber = choiceNumber +1;
		}
			return atGoal;
	}
	
	

	public static int nextChoiceColumn(int choiceNumber, int fromCol)
	{
		int nextColumn;
		nextColumn = fromCol + rowColIncrement[choiceNumber][0];
		return nextColumn;
	}

	public static int nextChoiceRow(int choiceNumber, int fromRow){
		int nextRow;
		nextRow = fromRow + rowColIncrement[choiceNumber][1];
		return nextRow;


	}

	public static boolean thisDecisionChoiceIsValid(int row, int column){
		if (row >= 0 && row < board.length &&
				column >= 0 && column < board[row].length)
			return true;
		else
			return false;
	}

	public static boolean goalHasBeenReached(int thisCharAt, String w){
		if (thisCharAt == w.length()-1)
			return true;
		else
			return false;
	}
	
	
	
	public boolean[] getTruth(){
		return wordFound;
	}
}

