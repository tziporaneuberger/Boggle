import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class FindWordsTests 
{
   MockBoggleBoard testBoard;
   ArrayList<String> words;
   char [][] board;
   FindWords findWords;
   
   
   @Before
   public void setUp()
   {
	   testBoard = new MockBoggleBoard();
	   
	   words=new ArrayList<String>();
	   
	   board = new char[][]{{'S','T','M','S','O'},{'A','I','A','D','A'},{'D','X','Q','P','L'},{'I','E','K','A','E'},{'P','C','L','T','S'}};
	   
	   testBoard.setBoard(board);
	   
	   findWords= new FindWords(testBoard,words);
   }
   
   //testing the goalHasBeenReached() method
   @Test
   public void passingInLastPositionReturnsTrue()
   {
	   assertTrue( FindWords.goalHasBeenReached(4, "Store"));
   }
   
   //testing the goalHasBeenReached() method
   @Test
   public void passingInNotLastPositionReturnsFalse()
   {
	    assertFalse( FindWords.goalHasBeenReached(2, "Store"));
   }
   
   
   //testing the thisDecisionChoiceIsValid() method
   @Test
   public void passingInRowOffBoardReturnsFalse()
   {
	   assertFalse(FindWords.thisDecisionChoiceIsValid(5,0));
   }
   
   
 //testing the thisDecisionChoiceIsValid() method
   @Test
   public void passingInColumnOffBoardReturnsFalse()
   {
	   assertFalse(FindWords.thisDecisionChoiceIsValid(4,-1));
   }
   
 //testing the thisDecisionChoiceIsValid() method
   @Test
   public void passingInColumnandRowOnBoardReturnsTrue()
   {
	   assertTrue(FindWords.thisDecisionChoiceIsValid(4,0));
   }
   
   
   
   // testing nextChoiceColumn() method
   @Test
   public void fifthChoiceFirstColumnReturnsZero()
   {
	   assertEquals(0,FindWords.nextChoiceColumn(4, 0));
   }
   
// testing nextChoiceColumn() method
   @Test
   public void secondChoiceFirstColumnReturnsOne()
   {
	   assertEquals(1,FindWords.nextChoiceColumn(1,0 ));
   }
   
   
   //testing the nextChoiceRow() method
   @Test
   public void eighthChoiceFourthRowReturnsThree()
   {
	   assertEquals(3,FindWords.nextChoiceRow(7, 3));
   }
   
 //testing the nextChoiceRow() method
   @Test
   public void firstChoiceFirstRowReturnsNegativeOne()
   {
	   assertEquals(-1,FindWords.nextChoiceRow(0, 0));
   }
 
   
   //testing the makeNextDecision() method
   // when calling makeDecisionMethod() :
   // pass it the 0 for firstletterposition, the row and the column where 
   //that position is found, and the word to look for on the board (uses the board above)
   @Test
   public void returnsTrueWhenWholeWordIsFound()
   {   
	   
	   assertTrue(findWords.makeNextDecision(0, 0, 1,"tide".toUpperCase()));
   }
   
   
 //testing the makeNextDecision() method
   @Test
   public void returnsFalseWhenOtherLettersAreNotAfterFirstLetter()
   {   
	   
	   assertFalse(findWords.makeNextDecision(0, 4, 3,"tide".toUpperCase()));
   }
   
   
   
   // testing the findFirstLetter() method
   @Test
   public void returnsPointIfLetterIsOnBoardStartingFromFirstPosition()
   {
	   Point thePoint = findWords.findFirstLetter('X',0,0);
	   
	   // instantiate a point for comparison
	   Point comparePoint = new Point (2,1);
	   
	   assertEquals(comparePoint.getRow(),thePoint.getRow());
	   assertEquals(comparePoint.getCol(),thePoint.getCol());
   }
   
// testing the findFirstLetter() method
   @Test
   public void returnsPointIfLetterIsOnBoardNotStartingFromFirstPosition()
   {
	   // board has L at (2,4) but we want it to find the next L somewhere else: at (4,2)
	   
	   Point thePoint = findWords.findFirstLetter('L',2,4);  
	  
	   // instantiate a point for comparison
	   Point comparePoint = new Point (4,2);
	   	   
	   assertEquals(comparePoint.getRow(),thePoint.getRow());
	   assertEquals(comparePoint.getCol(),thePoint.getCol());
   }
   
   
// testing the findFirstLetter() method
   @Test
   public void returnsNegativePointIfLetterIsNotOnBoardStartingFromFirstPosition()
   {
	   Point thePoint = findWords.findFirstLetter('V',0,0);  
	  
	   // instantiate a point for comparison
	   Point comparePoint = new Point (-1,-1);
	   	   
	   assertEquals(comparePoint.getRow(),thePoint.getRow());
	   assertEquals(comparePoint.getCol(),thePoint.getCol());
   }
   
   
   // testing the findAWord() method
   public void returnsTrueWhenWordIsFoundStartingFromFirstPosition()
   {
	   assertTrue(findWords.findAWord("soda".toUpperCase(),0,0));
   }
   
// testing the findAWord() method
   public void returnsTrueWhenWordIsFoundNotStartingFromFirstPosition()
   {
	   assertTrue(findWords.findAWord("soda".toUpperCase(),0,2));
   }
   
// testing the findAWord() method
   public void returnsFalseWhenWordIsNotFoundNotStartingFromFirstPosition()
   {
	   assertFalse(findWords.findAWord("yay".toUpperCase(),2,1));
   }
   
   
   //testing the fillInTruthArray() method
   public void returnsFalseForWordWithDoubleLetterWithOnlyOneOnBoard()
   {  
	   words.add("WALK");
	   words.add("SELL"); // only one L adjacent
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // sell, at index 1, should return false because it's not on the board
	   assertFalse(wordFound[1]);
   }
   
 //testing the fillInTruthArray() method
   public void returnsTrueForWordWithQ()
   {  
	   words.add("WALK");
	   words.add("QUIT"); 
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // QUIT, at index 1, should return true because it's on the board
	   assertTrue(wordFound[1]);
   }
   
 //testing the fillInTruthArray() method
   public void returnsTrueForWordWithFirstLetterAtPositionZeroZero()
   {  
	   words.add("WALK");
	   words.add("SIT"); 
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // SIT, at index 1, should return true because it's on the board
	   assertTrue(wordFound[1]);
   }
   
 //testing the fillInTruthArray() method
   public void returnsFalseForWordWithLettersOnBoardButNotConnected()
   {  
	   words.add("WALK");
	   words.add("PLAID"); 
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // PLAID, at index 1, should return false because it's not on the board
	   assertFalse(wordFound[1]);
   }
   
 //testing the fillInTruthArray() method
   public void returnsFalseFor1LetterWord()
   {  
	   words.add("WALK");
	   words.add("A"); 
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // A, at index 1, should return false because it's too short
	   assertFalse(wordFound[1]);
   }
   
   
 //testing the fillInTruthArray() method
   public void returnsFalseFor2LetterWord()
   {  
	   words.add("WALK");
	   words.add("AS"); 
	   words.add("PAT");
	   
	   findWords = new FindWords(testBoard,words);
	   
	   findWords.fillInTruthArray();
	   
	   boolean [] wordFound = findWords.getTruth();
	   
	   // AS, at index 1, should return false because it's too short
	   assertFalse(wordFound[1]);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
