package Boggle;

import java.util.Timer;
import java.util.TimerTask;

public class BoggleTimer {
	public int timePassedInMinutes = 0;
	Timer timePassed = new Timer();

	TimerTask task = new TimerTask() {
		public void run() {
			if (timePassedInMinutes>1){
				timePassed.cancel();
			}
			timePassedInMinutes++;
			System.out.println( timePassedInMinutes + " minutes passed");
		}

	};

	public void start() {
		timePassed.scheduleAtFixedRate(task, 60000,60000);

	}
	public static void main(String[] args) {
		BoggleTimer bt = new BoggleTimer();
		bt.start();
	}
}

