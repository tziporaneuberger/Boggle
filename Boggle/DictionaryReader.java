

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryReader {
	private ArrayList<String> dictionary;

	public DictionaryReader() {
		this.dictionary = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("C:\\Users\\Adina\\Documents\\ComputerProgrammingTouroCourses\\ComputerMethodology\\myWork\\TermProject\\src\\boggleWords.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			int i;
			try {
				while ((line = br.readLine()) != null) {
					dictionary.add(line);
				}
			} catch (IOException ex) {}
		} catch (FileNotFoundException ex) {}
	}

	public boolean search( String word) {

		    int first = 0;
		    int last = dictionary.size() - 1;
		    int mid;
		    while (first <= last) {
		        mid = ( first + last ) / 2;
		        if (word.compareTo(dictionary.get(mid))==0) {
		            return true;
		        } else if (word.compareTo(dictionary.get(mid)) < 0) {
		            last = mid - 1;
		            
		        } else {
		            first = mid + 1;
		           
		        }
		    }return false;
	}}