package Boggle;
import java.util.Scanner;
import java.time.*;
import java.util.ArrayList;
import java.util.Timer;
//mport java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard=new Scanner (System.in);
		BoggleBoard boggle = new BoggleBoard() ;
		boggle.getBoard();
		ArrayList <String> words=new ArrayList <String>();
		System.out.println(boggle);

		BoggleTimer timer=new BoggleTimer();
		timer.start();
		int minute=LocalDateTime.now().getMinute();
			
			System.out.println("\nEnter the words you see");
			while(keyboard.hasNext() && LocalDateTime.now().getMinute()-minute<3){
				words.add(keyboard.next());
			}
			System.out.println("Done");
			System.out.println("These are the words you entered: \n"+words);

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
