
import java.util.Timer;
import java.util.TimerTask;

public class BoggleTimer {
	int timePassedInSeconds = 0;
	Timer timePassed = new Timer();
	
	TimerTask task = new TimerTask() {
		public void run() {
			timePassedInSeconds++;
			System.out.println( timePassedInSeconds + " seconds passed");

		}

	};

	public void start() {
		timePassed.scheduleAtFixedRate(task, 1000,1000);

	}
	public static void main(String[] args) {
		BoggleTimer bt = new BoggleTimer();
		bt.start();
		
		
	}
}