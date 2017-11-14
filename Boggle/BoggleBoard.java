
import java.util.Random;

public class BoggleBoard {

	char[][]boggle;
	char[][] board;
	int num;//the number of rows

	public BoggleBoard(){   // missing q, need to fix the dice letter options , and a way to "mix up the dice"
		this.boggle= new char [][]{{'q','q','q','q','q','q'},
			//{'a', 'r', 't','l','e','d'}, 
			{'f','o','g','s','k','w'}
		,
			{'r','h','e', 'c', 't','m'}, {'n', 'u', 'a','b','i','y'},{'o', 'r', 'p','l','a','d'}, {'f','o','g','s','k','w'},
			{'b','h','a', 'h', 't','n'}, {'n', 'e', 'w','b','d','y'},{'a', 'j', 't','c','i','d'}, {'f','o','g','s','k','w'},
			{'f','h','e', 'g', 'v','m'}, {'n', 'o', 'd','m','i','x'},{'a', 'r', 's','l','e','k'}, {'f','o','g','s','k','w'},
			{'a','h','e', 'c', 'z','d'}, {'c', 'u', 'y','b','i','j'}};
			num=4;
		this.board=new char[num][num];
	}
	
	public void getBoard(){
		Random r=new Random();
		int randomIndex;
		int index=0;
		for (int row=0; row<num; row++){
			for (int column=0; column<num; column++ ){
				randomIndex=r.nextInt(6);  // changed to 6
				board[row][column]=boggle[index][randomIndex];
				index++;
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


