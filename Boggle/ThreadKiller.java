

import java.util.TimerTask;

public class ThreadKiller extends TimerTask {
	Thread t;
	
	public ThreadKiller(Thread t)
	{
		this.t = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.stop();
	}

}
