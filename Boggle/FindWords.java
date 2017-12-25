

import java.util.ArrayList;
public class FindWords {

	private static char[][] board;
	ArrayList<String> words;
	static boolean [] wordFound;
	private static int [][] rowColIncrement;

	public FindWords(BoggleBoard b, ArrayList<String> words){
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
	public void fillInTruthArray(){
		for(int i=0; i<words.size(); i++){
			if (words.get(i).isEmpty()){
				wordFound[i]=false;
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

			if ( firstLetterRow != -1){
				found = makeNextDecision(0,firstLetterRow,firstLetterColumn, word);
				if (found == false){
					found=findAWord(word, firstLetterRow, firstLetterColumn);
				}
				return found;
			}
			else{
				return false;
			}
	}

	public Point findFirstLetter(char c, int beginRow, int beginCol){
		int row=beginRow;
		int col= beginCol+1;
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

	public boolean findNextLetter(){
		return true;
	}


	public static boolean makeNextDecision(int lastCharAt, int fromRow, int fromCol, String s)
	{  
		int thisCharAt = lastCharAt + 1;
		int numberOfChoices =8;
		int choiceNumber =0;
		boolean atGoal = false;

		while (atGoal == false && choiceNumber < numberOfChoices){
			int row = nextChoiceRow(choiceNumber,fromRow);
			int col = nextChoiceColumn(choiceNumber,fromCol);
			if (thisDecisionChoiceIsValid (row,col) && board[row][col]== s.charAt(thisCharAt))
			{ 
					if (goalHasBeenReached(thisCharAt, s)){
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
	
	public String getTruthString(){
		StringBuilder info = new StringBuilder();
		for (boolean b: wordFound){
			info.append(b+"\n");
		}
		return info.toString();
	}
	
	public boolean[] getTruth(){
		return wordFound;
	}
}

