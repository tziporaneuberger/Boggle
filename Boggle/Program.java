
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Timer;
//import java.util.TimerTask;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		// instantiate dictionary reader that reads in the dictionary file
		DictionaryReader dr = new DictionaryReader();
		
		int roundNum = 0;
		int points=0;
		int pointsPerRound=0;
		int totalPoints=0;
		System.out.println("Welcome to Boggle!");
		System.out.println("Please choose from the following options:\n " + "1.New round\n 2.Quit the game");

		Scanner keyboard = new Scanner(System.in);

		int choice = keyboard.nextInt();
		while (choice != 2) {
			switch (choice) {
			case 1:// new round
				 
				roundNum++;
				
			    BoggleBoard boggle;
			    
			    boggle = new BoggleBoard();
			    
				boggle.makeBoard();
				points=0;
				pointsPerRound=0;

				System.out.println("You have 2 minutes to enter words\n");

				System.out.println(boggle);

				

				ArrayList<String> words = new ArrayList<String>();

				Thread t = new InputReader(words);

				ThreadKiller tk = new ThreadKiller(t);
				Timer timer = new Timer();
				timer.schedule(tk, 120 * 1000);

				t.start();

				try {
					Thread.sleep(120 * 1001);

					// t.join();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

				timer.cancel();

				System.out.println("\nTime's up.");
				
				//make sure there are no duplicates 
				Set<String> hs = new HashSet<>();
				hs.addAll(words);
				words.clear();
				words.addAll(hs);
                
				
			try {
				// checks if the words are on the board
				FindWords find = new FindWords(boggle, words);
				find.fillInTruthArray();
				boolean[] trueFalse = find.getTruth();

				for (int i = 0; i < words.size(); i++) {
					System.out.printf("%-10s ", words.get(i));
					// if not on the board
					if (trueFalse[i] == false) {
						if (words.get(i)== null){
							
						}
						else{
						System.out.println("is not on the board");
						}
					}
					//it is on board- now check if it's in dictionary
					else{
						boolean vr = dr.search(words.get(i));
						if (vr==false){
						System.out.println("is not in dictionary");
						}
						else{
							points = calculateScore(words.get(i));
							System.out.println(points);
							pointsPerRound+=points;
						}
					}
				}
			}
			catch (StackOverflowError e){
				System.out.println("StackOverFlowError. \nThe game will continue with the next round");
			}

				break;
			default:
				System.out.println("Invalid entry. Please try again.");
				break;
			}

			// user may be still entering words when timer is up, so need to clear the
			// buffer
			// so that it will carry out the next choice
			
			if(choice==1)
				
			{System.out.println("\nTotal points for round #" + roundNum + ": "+ pointsPerRound);
			totalPoints+= pointsPerRound;
			System.out.println("Total points for this game: "+ totalPoints);
			}
			
			
			//choice = 2;
			
			System.out.println("\nEnter 1 to start a new round or 2 to quit the game.");
			choice = keyboard.nextInt();
			//System.out.println(choice);
			// if (keyboard.hasNext()){keyboard.next();}choice =
			// Integer.parseInt(keyboard.nextLine())}
		}
	}
	
	

	public static int calculateScore(String word){
		switch(word.length()){
		case 1:
			   return 0;
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 2;
		default:
			return 3;
		}

	}
}