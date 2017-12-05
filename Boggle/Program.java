
import java.util.Scanner;
import java.time.*;
import java.util.ArrayList;
import java.util.Timer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Boggle!");
		System.out.println("Please choose from the following options:\n "+
				           "1.New round\n2.Quit the game" );
		

		Scanner keyboard=new Scanner (System.in);
		
		int choice = keyboard.nextInt();
		
		while (choice!=2)
		{
		    switch(choice)
		    {
		    case 1:// new round
					    	BoggleBoard boggle = new BoggleBoard() ;
							boggle.getBoard();
							
							System.out.println(boggle);
							
							
							//Timer timer = new Timer();
							//timer.schedule((new Timer(TimerResponse)), 60000 /* 60 secs */);
							
							
							
							ArrayList <String> words=new ArrayList <String>();
			
						

					       /* try
					        {
					        	Test myTest = new Test ();
					            words = myTest.getInput();
					        }
					        catch( Exception e )
					        {
					            System.out.println( e );
					        }*/
							
							System.out.println("\nEnter any words you see. You have 1 minute");
							
							int minute=LocalDateTime.now().getMinute();
							
							while(LocalDateTime.now().getMinute()-minute< 1){  // start with 1 min. for testing purposes
								words.add(keyboard.nextLine());
							}
							
							words.remove(words.size()-1);    // remove last word, because past the timer 
							
							System.out.println("\nTimes up.");
							System.out.println("These are the words you entered: \n"+words);
		    	break;
		    	default:
		    		    System.out.println("Invalid entry. Please try again.");
		        break;
		    }
		    
			
			System.out.println("\nEnter 1 to start a new round or 2 to quit to the game.");
			choice = keyboard.nextInt();
		}
		
		System.exit(0);

			/*public static void runExample(){
			// construct the URL to the Wordnet dictionary directory
			String wnhome = System.getenv("WNHOME");
			String path = wnhome + File.separator + "dict";
			URL url = null;
			try{ url = new URL("file", null, path); } 
			catch(MalformedURLException e){ e.printStackTrace(); }
			if(url == null) return;

			// construct the dictionary object and open it
			IDictionary dict = new Dictionary(url);
			dict.open();

			// look up first sense of the word "dog"
			IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
			IWordID wordID = idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);
			System.out.println("Id = " + wordID);
			System.out.println("Lemma = " + word.getLemma());
			System.out.println("Gloss = " + word.getSynset().getGloss());

		}*/
		}

	}
