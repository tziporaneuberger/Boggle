

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader extends Thread {

	ArrayList<String> strings;
	
	public InputReader(ArrayList<String> strings)
	{
		this.strings = strings;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			strings.add(sc.nextLine().toUpperCase());

		}
		
	}

}
